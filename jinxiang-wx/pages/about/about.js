// about.js
var app = getApp()
var util = require("../../utils/util.js");


var api = require("../../config/api.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    load_statue: true,
    shopInfo: {
      jinxiang_mall_name: 'jinxiang',
      jinxiang_mall_address: '',
      latitude: 31.201900,
      longitude: 121.587839,
      jinxiang_mall_phone: '',
      jinxiang_mall_qq: ''
    },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    util.request(api.configInfo, {}).then(function (res) {
      if (res.errno === 0) {
        if (res.data) {
          that.setData({
            shopInfo: res.data
          });
        }
      }
    });
  },

  showLocation: function (e) {
    var that = this
    wx.openLocation({
      latitude: that.data.shopInfo.latitude,
      longitude: that.data.shopInfo.longitude,
      name: that.data.shopInfo.name,
      address: that.data.shopInfo.address,
    })
  },
  callPhone: function (e) {
    var that = this
    wx.makePhoneCall({
      phoneNumber: that.data.shopInfo.linkPhone,
    })
  },
  reLoad: function (e) {
    this.loadShopInfo();
  }
})