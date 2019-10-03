package com.cskaoyan.mall.admin.vo.grouponvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;

import java.util.List;

public class GrouponVo {
    CskaoyanMallGroupon groupon;
    CskaoyanMallGoods goods;
    CskaoyanMallGrouponRules rules;
    List<SubGrouponsVo> subGroupons;

    public CskaoyanMallGroupon getGroupon() {
        return groupon;
    }

    public void setGroupon(CskaoyanMallGroupon groupon) {
        this.groupon = groupon;
    }

    public CskaoyanMallGoods getGoods() {
        return goods;
    }

    public void setGoods(CskaoyanMallGoods goods) {
        this.goods = goods;
    }

    public CskaoyanMallGrouponRules getRules() {
        return rules;
    }

    public void setRules(CskaoyanMallGrouponRules rules) {
        this.rules = rules;
    }

    public List<SubGrouponsVo> getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(List<SubGrouponsVo> subGroupons) {
        this.subGroupons = subGroupons;
    }

    @Override
    public String toString() {
        return "GrouponVo{" +
                "groupon=" + groupon +
                ", goods=" + goods +
                ", rules=" + rules +
                ", subGroupons=" + subGroupons +
                '}';
    }
}
