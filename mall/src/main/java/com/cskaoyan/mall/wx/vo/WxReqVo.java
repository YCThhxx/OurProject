package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.wx.util.UserInfo;

public class WxReqVo {

    private String code;
    private UserInfo userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
