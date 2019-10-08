package com.cskaoyan.mall.wx.util;

import java.math.BigDecimal;
import java.util.List;

public class CheckData {
        List checkedGoodsList;

        String checkedAddress;

        int availableCouponLength;

        BigDecimal goodsTotalPrice;

        BigDecimal freightPrice;

        BigDecimal couponPrice;

         BigDecimal grouponPrice;

        BigDecimal orderTotalPrice;

         BigDecimal actualPrice;

        int cartId;

        int addressId;

        int message;

        int grouponLinkId;

        int grouponRulesId;

    public List getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public String getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(String checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(BigDecimal grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getGrouponLinkId() {
        return grouponLinkId;
    }

    public void setGrouponLinkId(int grouponLinkId) {
        this.grouponLinkId = grouponLinkId;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }
}




