package com.baijuvip.jinxiang.wx.dto;

public class GoodDto {
    private String remark;
    private String goods_img;
    private String[] gallery;
    private String[] goodsDetailImg;
    private String goodsDetailRemark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public String[] getGoodsDetailImg() {
        return goodsDetailImg;
    }

    public void setGoodsDetailImg(String[] goodsDetailImg) {
        this.goodsDetailImg = goodsDetailImg;
    }

    public String getGoodsDetailRemark() {
        return goodsDetailRemark;
    }

    public void setGoodsDetailRemark(String goodsDetailRemark) {
        this.goodsDetailRemark = goodsDetailRemark;
    }
}
