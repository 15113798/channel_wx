// pages/ucenter/userIntegralChange/userIntegralChange.js
var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');
var check = require('../../../utils/check.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    integral: {
      integral: 0,
      mobile: ''
    }
  },

  cancel: function() {
    wx.navigateBack();
  },

  bindinputIntegral(event) {
    let integral = this.data.integral;
    integral.integral = event.detail.value;
    this.setData({
      integral: integral
    });
  },

  bindinputMobile(event) {
    let integral = this.data.integral;
    integral.mobile = event.detail.value;
    this.setData({
      integral: integral
    });
  },

  save() {
    console.log(this.data.integral)
    let integral = this.data.integral;

    if (integral.integral == '') {
      util.showErrorToast('请输入积分');
      return false;
    }
    if (integral.mobile == '') {
      util.showErrorToast('请输入手机号码');
      return false;
    }
    if (!check.isValidPhone(integral.mobile)) {
      util.showErrorToast('手机号不正确');
      return false;
    }
    let that = this;
    util.request(api.IntegralSave, integral, 'POST').then(function (res) {
      if (res.errno === 0) {
        
        wx.navigateBack();
      }
    });

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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