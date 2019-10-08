package com.cskaoyan.mall.wx.vo.orderVo;

import com.cskaoyan.mall.wx.util.HandleOption;

import java.util.List;

public class OrderListVo {
    int id;
    String orderStatusText;
    boolean isGroupin;
    String orderSn;
    float actualPrice;
    int orderStatus;
    List<GoodsListVo> goodsList;
    HandleOption handleOption;

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderListVo{" +
                "id=" + id +
                ", orderStatusText='" + orderStatusText + '\'' +
                ", isGroupin=" + isGroupin +
                ", orderSn='" + orderSn + '\'' +
                ", actualPrice=" + actualPrice +
                ", orderStatus=" + orderStatus +
                ", goodsList=" + goodsList +
                ", handleOption=" + handleOption +
                '}';
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public boolean isGroupin() {
        return isGroupin;
    }

    public void setGroupin(boolean groupin) {
        isGroupin = groupin;
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

    public List<GoodsListVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListVo> goodsList) {
        this.goodsList = goodsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }
}
