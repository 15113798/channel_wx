package com.baijuvip.jinxiang.wx.vo;

import java.math.BigDecimal;

public class GrouponRuleVo {
    private Integer id;
    private String name;
    private String brief;
    private String picUrl;
    private BigDecimal counterPrice;
    private BigDecimal retailPrice;
    private BigDecimal grouponPrice;
    private BigDecimal grouponDiscount;
    private Integer grouponMember;

    public BigDecimal getGrouponDiscount() {
        return grouponDiscount;
    }

    public void setGrouponDiscount(BigDecimal grouponDiscount) {
        this.grouponDiscount = grouponDiscount;
    }

    public Integer getGrouponMember() {
        return grouponMember;
    }

    public void setGrouponMember(Integer grouponMember) {
        this.grouponMember = grouponMember;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(BigDecimal grouponPrice) {
        this.grouponPrice = grouponPrice;
    }
}
