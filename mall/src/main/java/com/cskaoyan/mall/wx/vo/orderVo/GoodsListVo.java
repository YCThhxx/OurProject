package com.cskaoyan.mall.wx.vo.orderVo;

public class GoodsListVo {
    int number;
    String picUrl;
    int id;
    String goodsName;

    @Override
    public String toString() {
        return "GoodsListVo{" +
                "number=" + number +
                ", picUrl='" + picUrl + '\'' +
                ", id=" + id +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
