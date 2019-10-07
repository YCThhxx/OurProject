package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;
import com.cskaoyan.mall.admin.bean.CskaoyanMallOrder;
import com.cskaoyan.mall.admin.bean.CskaoyanMallOrderGoods;

import java.util.List;

public class DetailData {
    AvatorData creator;

    CskaoyanMallGroupon groupon;

    List<AvatorData> joiners;

    int linkGrouponId;

    List<CskaoyanMallOrderGoods> orderGoods;

    CskaoyanMallOrder orderInfo;

    CskaoyanMallGrouponRules rules;

    public AvatorData getCreator() {
        return creator;
    }

    public void setCreator(AvatorData creator) {
        this.creator = creator;
    }

    public CskaoyanMallGroupon getGroupon() {
        return groupon;
    }

    public void setGroupon(CskaoyanMallGroupon groupon) {
        this.groupon = groupon;
    }

    public List<AvatorData> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<AvatorData> joiners) {
        this.joiners = joiners;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }

    public List<CskaoyanMallOrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<CskaoyanMallOrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public CskaoyanMallOrder getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(CskaoyanMallOrder orderInfo) {
        this.orderInfo = orderInfo;
    }

    public CskaoyanMallGrouponRules getRules() {
        return rules;
    }

    public void setRules(CskaoyanMallGrouponRules rules) {
        this.rules = rules;
    }
}
