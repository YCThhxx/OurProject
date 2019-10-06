package com.cskaoyan.mall.wx.util;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;
import com.cskaoyan.mall.admin.bean.CskaoyanMallOrderGoods;

import java.math.BigDecimal;
import java.util.List;

public class GrouponMyData {
    BigDecimal actualPrice;

    String creator;

    List<CskaoyanMallOrderGoods> goodsList;

    CskaoyanMallGroupon groupon;

    HandleOption handleOption;

    int id;

    boolean isCreator;

    int joinerCount;

    int orderId;

    String orderSn;

    String orderStatusText;

    CskaoyanMallGrouponRules rules;

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<CskaoyanMallOrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<CskaoyanMallOrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public CskaoyanMallGroupon getGroupon() {
        return groupon;
    }

    public void setGroupon(CskaoyanMallGroupon groupon) {
        this.groupon = groupon;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public int getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(int joinerCount) {
        this.joinerCount = joinerCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public CskaoyanMallGrouponRules getRules() {
        return rules;
    }

    public void setRules(CskaoyanMallGrouponRules rules) {
        this.rules = rules;
    }
}
