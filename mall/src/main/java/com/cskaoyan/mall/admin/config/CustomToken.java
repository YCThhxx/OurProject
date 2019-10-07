package com.cskaoyan.mall.admin.config;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义的token,携带type,用于判断认证前台还是后端
 */
public class CustomToken extends UsernamePasswordToken {
    String type;

    public CustomToken(String username, String password,String type) {
        super(username, password);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
