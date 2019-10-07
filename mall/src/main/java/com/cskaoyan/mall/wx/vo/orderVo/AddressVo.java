package com.cskaoyan.mall.wx.vo.orderVo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AddressVo {
    String consignee;
    int userId;
    int provinveId;
    int cityId;
    int areaId;
    String address;
    String mobile;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;

    @Override
    public String toString() {
        return "AddressVo{" +
                "consignee='" + consignee + '\'' +
                ", userId=" + userId +
                ", provinveId=" + provinveId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", addTime=" + addTime +
                '}';
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProvinveId() {
        return provinveId;
    }

    public void setProvinveId(int provinveId) {
        this.provinveId = provinveId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
