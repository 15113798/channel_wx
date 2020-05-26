var util = require('../../../utils/util.js');
var check = require('../../../utils/check.js');
var api = require('../../../config/api.js');

var app = getApp();

Page({
  data: {
    content: '',
    detailContent:'',
    detailFiles:[],
    hasPicture: false,
    detailUrls:[],
    picUrls: [],
    files: [],
    goodsUrls: '',
    goodsfiles: [],
    signFormList: [{
      color: '',
      size: '',
      value: ''
    }]
  },
  goodsImage: function (e) {
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        that.setData({
          goodsfiles: that.data.files.concat(res.tempFilePaths)
        });
        that.goodsupload(res);
      }
    })
  },
  goodsupload: function (res) {
    var that = this;
    const uploadTask = wx.uploadFile({
      url: api.StorageUpload,
      filePath: res.tempFilePaths[0],
      name: 'file',
      success: function (res) {
        var _res = JSON.parse(res.data);
        if (_res.errno === 0) {
          var url = _res.data.url
          that.setData({
            goodsUrls: url
          })
        }
      },
      fail: function (e) {
        wx.showModal({
          title: '错误',
          content: '上传失败',
          showCancel: false
        })
      },
    })
    uploadTask.onProgressUpdate((res) => {
      console.log('上传进度', res.progress)
      console.log('已经上传的数据长度', res.totalBytesSent)
      console.log('预期需要上传的数据总长度', res.totalBytesExpectedToSend)
    })
  },
  chooseImage: function (e) {
    if (this.data.files.length >= 10) {
      util.showErrorToast('只能上传十张图片')    
      return false;
    }
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        that.setData({
          files: that.data.files.concat(res.tempFilePaths)
        });
        that.upload(res);
      }
    })
  },
  upload: function (res) {
    var that = this;
    const uploadTask = wx.uploadFile({
      url: api.StorageUpload,
      filePath: res.tempFilePaths[0],
      name: 'file',
      success: function (res) {
        var _res = JSON.parse(res.data);
        if (_res.errno === 0) {
          var url = _res.data.url
          that.data.picUrls.push(url)
          that.setData({
            hasPicture: true,
            picUrls: that.data.picUrls
          })
        }
      },
      fail: function (e) {
        wx.showModal({
          title: '错误',
          content: '上传失败',
          showCancel: false
        })
      },
    })

    uploadTask.onProgressUpdate((res) => {
      console.log('上传进度', res.progress)
      console.log('已经上传的数据长度', res.totalBytesSent)
      console.log('预期需要上传的数据总长度', res.totalBytesExpectedToSend)
    })

  },


  chooseDetailImage: function (e) {
    if (this.data.detailFiles.length >= 10) {
      util.showErrorToast('只能上传十张图片')    
      return false;
    }
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        that.setData({
          detailFiles: that.data.detailFiles.concat(res.tempFilePaths)
        });
        that.detailupload(res);
      }
    })
  },

  detailupload: function (res) {
    console.log( res.tempFilePaths[0]);
    var that = this;
    const uploadTask = wx.uploadFile({
      url: api.StorageUpload,
      filePath: res.tempFilePaths[0],
      name: 'file',
      success: function (res) {
        var _res = JSON.parse(res.data);
        if (_res.errno === 0) {
          var url = _res.data.url
          that.data.detailUrls.push(url)
          that.setData({
            hasPicture: true,
            detailUrls: that.data.detailUrls
          })
        }
      },
      fail: function (e) {
        wx.showModal({
          title: '错误',
          content: '上传失败',
          showCancel: false
        })
      },
    })

    uploadTask.onProgressUpdate((res) => {
      console.log('上传进度', res.progress)
      console.log('已经上传的数据长度', res.totalBytesSent)
      console.log('预期需要上传的数据总长度', res.totalBytesExpectedToSend)
    })

  },
  
  previewImage: function (e) {
    wx.previewImage({
      current: e.currentTarget.id, // 当前显示图片的http链接
      urls: this.data.files // 需要预览的图片http链接列表
    })
  },
  contentInput: function (e) {
    this.setData({
      content: e.detail.value,
    });
  },
  submitFeedback: function (e) {
    // if (!app.globalData.hasLogin) {
    //   wx.navigateTo({
    //     url: "/pages/auth/login/login"
    //   });
    // }
    let that = this;
    if (that.data.content == '') {
      util.showErrorToast('请输入商品名称');
      return false;
    }
    var signFormList = this.data.signFormList;
    var signFormText = '';
    for (var i = 0; i < signFormList.length; i++) {
      if (signFormList[i].color != null && signFormList[i].size && signFormList[i].value) {
        signFormText += "颜色：" + signFormList[i].color + ", 规格：" + signFormList[i].size + ", 库存：" + signFormList[i].value + ";"
      }else{
        util.showErrorToast('商品参数不能为空');
        return false;
      }
    }
    var remark="商品名称："+that.data.content +";"+signFormText;
    console.log(remark);
    if (that.data.goodsUrls == '') {
      util.showErrorToast('请上传商品图片');
      return false;
    }
    if (that.data.picUrls.length == 0) {
      util.showErrorToast('请上传宣传图片');
      return false;
    }
    if (that.data.detailUrls.length == 0) {
      util.showErrorToast('请上传详情图片');
      return false;
    }
    wx.showLoading({
      title: '提交中...',
      mask: true,
    });
   
    util.request(api.GoodsaddGoods, {
      remark: remark,
      goods_img: that.data.goodsUrls,
      gallery: that.data.picUrls,
      goodsDetailImg :that.data.detailUrls,
      //goodsDetailRemark :that.data.goodsDetailRemark,
      goodsDetailRemark :'1',
    }, 'POST').then(function (res) {
      wx.hideLoading();
      if (res.errno === 0) {
        wx.showToast({
          title: '提交成功！',
          icon: 'success',
          duration: 2000,
          complete: function () {
            that.setData({
              signFormList: [],
            })
            that.setData({
              signFormList: [{
                color: '',
                size: '',
                value: ''
              }],
              content: '',
              contentLength: 0,
              hasPicture: false,
              picUrls: [],
              files: [],
              goodsUrls: '',
              goodsfiles: [],
              goodsDetailImg : [],
              goodsDetailRemark :'',
              detailUrls: [],
              detailFiles :[],
            });
          }
        });
      } else {
        util.showErrorToast(res.errmsg);
      }

    });
  },
  //添加
  add: function () {
    var signFormList = this.data.signFormList;
    signFormList.push({
      color: '',
      size: '',
      value: ''
    });
    this.setData({
      signFormList: signFormList
    })
  },
  ColorInput: function (e) {
    var value = e.detail.value;
    var index = e.target.dataset.index;
    var signFormList = this.data.signFormList;
    signFormList[index].color = value
    this.setData({
      signFormList: signFormList
    })
  },
  SizeInput: function (e) {
    var value = e.detail.value;
    var index = e.target.dataset.index;
    var signFormList = this.data.signFormList;
    signFormList[index].size = value
    this.setData({
      signFormList: signFormList
    })
  },
  ValueInput: function (e) {
    var value = e.detail.value;
    var index = e.target.dataset.index;
    var signFormList = this.data.signFormList;
    signFormList[index].value = value
    this.setData({
      signFormList: signFormList
    })
  },
  onLoad: function () {
  },
  onReady: function () {

  },
  onShow: function () {

  },
  onHide: function () {
    // 页面隐藏

  },
  onUnload: function () {
    // 页面关闭
  }
})