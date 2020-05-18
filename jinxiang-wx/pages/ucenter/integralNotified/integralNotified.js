var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');

var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    integralNotifiedList: [],
    scrollTop: 0,
    showPage: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getIntegralNotifiedList();
  },

  /**
   * 获取积分通知记录
   */
  getIntegralNotifiedList: function () {
    let that = this;
    that.setData({
      scrollTop: 0,
      showPage: false,
      integralNotifiedList: []
    });
    util.request(api.IntegralNotifiedList, {}).then(function (res) {
      if (res.errno === 0) {

        that.setData({
          scrollTop: 0,
          integralNotifiedList: res.data,
          showPage: true
        });
      }
    });
  },
  /**
   * 发送消息通知
   */
  sendTemplateMessage: function(e) {
    let that = this;
    var id = e.currentTarget.dataset.id;
    var index = e.currentTarget.dataset.index;
    util.request(api.IntegralNotice, { integralId: id}, 'POST').then(function (res) {
      if (res.errno === 0) {
        that.setData({
          integralNotifiedList: that.data.integralNotifiedList.splice(index, 1)
        });
      }
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})