package com.cskaoyan.mall.wx.vo.homeIndex;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;

import java.util.List;

public class FloorGoodsInfo {

    private String name;

    private List<CskaoyanMallGoods> goodsList;//id最大的两个

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CskaoyanMallGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<CskaoyanMallGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
