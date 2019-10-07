package com.cskaoyan.mall.wx.vo.homeIndex;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;

import java.math.BigDecimal;
import java.util.List;

public class GrouponRulesInfo {


    private BigDecimal groupon_price;//discount

    private GoodsInfo goods;

    private Integer groupon_member;

    public BigDecimal getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(BigDecimal groupon_price) {
        this.groupon_price = groupon_price;
    }

    public GoodsInfo getGoods() {
        return goods;
    }

    public void setGoods(GoodsInfo goods) {
        this.goods = goods;
    }

    public Integer getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.groupon_member = groupon_member;
    }
}
