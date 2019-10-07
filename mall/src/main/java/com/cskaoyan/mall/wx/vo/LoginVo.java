package com.cskaoyan.mall.wx.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginVo {

    //长度不大于6/非空
    @NotNull
    @Size(max = 6, message = "max length is 6")
    String username;
    //非空
    @NotNull
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
}
