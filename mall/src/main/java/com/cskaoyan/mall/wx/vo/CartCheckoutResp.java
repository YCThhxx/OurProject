package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;

import java.util.List;

public class CartCheckoutResp {
    List<CskaoyanMallCart> checkedGoodsList;
    CskaoyanMallAddress checkedAddress;
    int availableCouponLength;
    double actualPrice;
    double couponPrice;
    double grouponPrice;
    double freightPrice;
    double goodsTotalPrice;
    double orderTotalPrice;
    int addressId;
    int couponId;
    int grouponRulesId;

    public CartCheckoutResp() {
    }

    public List<CskaoyanMallCart> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<CskaoyanMallCart> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public CskaoyanMallAddress getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(CskaoyanMallAddress checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public CartCheckoutResp(List<CskaoyanMallCart> checkedGoodsList, CskaoyanMallAddress checkedAddress, int availableCouponLength, double actualPrice, double couponPrice, double grouponPrice, double freightPrice, double goodsTotalPrice, double orderTotalPrice, int addressId, int couponId, int grouponRulesId) {
        this.checkedGoodsList = checkedGoodsList;
        this.checkedAddress = checkedAddress;
        this.availableCouponLength = availableCouponLength;
        this.actualPrice = actualPrice;
        this.couponPrice = couponPrice;
        this.grouponPrice = grouponPrice;
        this.freightPrice = freightPrice;
        this.goodsTotalPrice = goodsTotalPrice;
        this.orderTotalPrice = orderTotalPrice;
        this.addressId = addressId;
        this.couponId = couponId;
        this.grouponRulesId = grouponRulesId;
    }
}
