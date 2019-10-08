package com.cskaoyan.mall.wx.vo.orderVo;

import com.cskaoyan.mall.wx.util.HandleOption;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderInfoVo {
    int id;
    String consignee;
    String address;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;

    String orderSn;
    float actualPrice;
    String mobile;
    String orderStatusText;
    float goodsPrice;
    float couponPrice;
    float freightPrice;
    HandleOption handleOption;

    @Override
    public String toString() {
        return "OrderInfoVo{" +
                "id=" + id +
                ", consignee='" + consignee + '\'' +
                ", address='" + address + '\'' +
                ", addTime=" + addTime +
                ", orderSn='" + orderSn + '\'' +
                ", actualPrice=" + actualPrice +
                ", mobile='" + mobile + '\'' +
                ", orderStatusText='" + orderStatusText + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", couponPrice=" + couponPrice +
                ", freightPrice=" + freightPrice +
                ", handleOption=" + handleOption +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(float actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public float getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(float couponPrice) {
        this.couponPrice = couponPrice;
    }

    public float getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(float freightPrice) {
        this.freightPrice = freightPrice;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }
}
