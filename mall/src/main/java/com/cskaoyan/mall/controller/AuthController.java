package com.cskaoyan.mall.controller;


import com.cskaoyan.mall.vo.BaseRespVo;
import com.cskaoyan.mall.vo.LoginVo;
import com.cskaoyan.mall.vo.UserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AuthController {

    @RequestMapping("admin/auth/login")
    public BaseRespVo login(@RequestBody LoginVo vo){
        String data = "84c40030";//先不管这个返回数据
        BaseRespVo ok = BaseRespVo.ok(data);
        return ok;
    }

    @RequestMapping("admin/auth/info")
    public BaseRespVo info(String token){
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatar("");
        userInfo.setName("admin");
        ArrayList perms = new ArrayList();
        perms.add("*");
        userInfo.setPerms(perms);
        ArrayList roles = new ArrayList();
        roles.add("超级管理员");
        userInfo.setRoles(roles);
        BaseRespVo ok = BaseRespVo.ok(userInfo);
        return ok;
    }
}
