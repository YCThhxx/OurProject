package com.cskaoyan.mall.wx.vo.goodsvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;

import java.util.List;

public class GoodsListVo {

    int count;
    List<CskaoyanMallCategory> filterCategoryList;
    List<CskaoyanMallGoods> goodsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CskaoyanMallCategory> getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(List<CskaoyanMallCategory> filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public List<CskaoyanMallGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<CskaoyanMallGoods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "GoodsListVo{" +
                "count=" + count +
                ", filterCategoryList=" + filterCategoryList +
                ", goodsList=" + goodsList +
                '}';
    }
}
