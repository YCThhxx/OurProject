package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.LoginVo;
import com.cskaoyan.mall.admin.vo.UserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin/auth")
public class AuthController {
    @RequestMapping("login")
    public BaseResponseVo login(@RequestBody  LoginVo loginVo){
        BaseResponseVo ok = BaseResponseVo.ok("888899-822642");

        return ok;
    }

    @RequestMapping("info")
    public BaseResponseVo info(String token){
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatar("");
        userInfo.setName("admin123");
        ArrayList perms = new ArrayList();
        perms.add("*");
        userInfo.setPerms(perms);

        ArrayList roles = new ArrayList();
        roles.add("超级管理员");
        userInfo.setRoles(roles);

        BaseResponseVo ok = BaseResponseVo.ok(userInfo);

        return ok;
    }
}
