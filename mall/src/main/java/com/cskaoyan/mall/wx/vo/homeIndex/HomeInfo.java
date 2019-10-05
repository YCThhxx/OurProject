package com.cskaoyan.mall.wx.vo.homeIndex;

import com.cskaoyan.mall.admin.bean.*;

import java.util.List;

public class HomeInfo {

    List<CskaoyanMallGoods> newGoodsList;//所有isNew商品
    List<CskaoyanMallCoupon> couponList;
    List<CskaoyanMallCategory> channel;
    List<GrouponRulesInfo> grouponList;
    List<CskaoyanMallAd> banner;
    List<CskaoyanMallBrand> brandList;
    List<CskaoyanMallGoods> hotGoodsList;//所有isHot商品
    List<CskaoyanMallTopic> topicList;
    List<FloorGoodsInfo> floorGoodsList;//选择id最小的四个大类

    public List<CskaoyanMallGoods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<CskaoyanMallGoods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<CskaoyanMallCoupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<CskaoyanMallCoupon> couponList) {
        this.couponList = couponList;
    }

    public List<CskaoyanMallCategory> getChannel() {
        return channel;
    }

    public void setChannel(List<CskaoyanMallCategory> channel) {
        this.channel = channel;
    }

    public List<GrouponRulesInfo> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<GrouponRulesInfo> grouponList) {
        this.grouponList = grouponList;
    }

    public List<CskaoyanMallAd> getBanner() {
        return banner;
    }

    public void setBanner(List<CskaoyanMallAd> banner) {
        this.banner = banner;
    }

    public List<CskaoyanMallBrand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<CskaoyanMallBrand> brandList) {
        this.brandList = brandList;
    }

    public List<CskaoyanMallGoods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<CskaoyanMallGoods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<CskaoyanMallTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<CskaoyanMallTopic> topicList) {
        this.topicList = topicList;
    }

    public List<FloorGoodsInfo> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<FloorGoodsInfo> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }
}
