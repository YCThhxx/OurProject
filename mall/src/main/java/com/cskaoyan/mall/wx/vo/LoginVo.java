package com.cskaoyan.mall.wx.vo;

public class LoginVo {
    String token;

    String tokenExpire;

    AvatorData userInfo;

    String username;

    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(String tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public AvatorData getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(AvatorData userInfo) {
        this.userInfo = userInfo;
    }
}
