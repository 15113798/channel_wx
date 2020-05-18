package com.baijuvip.jinxiang.admin.dto;

import com.baijuvip.jinxiang.db.domain.JinxiangGoods;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsAttribute;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsProduct;
import com.baijuvip.jinxiang.db.domain.JinxiangGoodsSpecification;

public class GoodsAllinone {
    JinxiangGoods goods;
    JinxiangGoodsSpecification[] specifications;
    JinxiangGoodsAttribute[] attributes;
    JinxiangGoodsProduct[] products;

    public JinxiangGoods getGoods() {
        return goods;
    }

    public void setGoods(JinxiangGoods goods) {
        this.goods = goods;
    }

    public JinxiangGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(JinxiangGoodsProduct[] products) {
        this.products = products;
    }

    public JinxiangGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(JinxiangGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public JinxiangGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(JinxiangGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
