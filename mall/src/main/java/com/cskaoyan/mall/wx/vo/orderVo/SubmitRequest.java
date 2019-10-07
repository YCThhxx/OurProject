package com.cskaoyan.mall.wx.vo.orderVo;

public class SubmitRequest {
    int addressId;
    int cartId;
    int couponId;
    int grouponLinkId;
    int grouponRulesId;
    String message;

    @Override
    public String toString() {
        return "SubmitRequest{" +
                "addressId=" + addressId +
                ", cartId=" + cartId +
                ", couponId=" + couponId +
                ", grouponLinkId=" + grouponLinkId +
                ", grouponRulesId=" + grouponRulesId +
                ", message='" + message + '\'' +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
