package com.cskaoyan.mall.wx.util;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;

import java.math.BigDecimal;

public class GrouponData2 {

    CskaoyanMallGoods goods;

    int groupon_member;

    BigDecimal groupon_price;

    public CskaoyanMallGoods getGoods() {
        return goods;
    }

    public void setGoods(CskaoyanMallGoods goods) {
        this.goods = goods;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    public BigDecimal getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(BigDecimal groupon_price) {
        this.groupon_price = groupon_price;
    }
}
