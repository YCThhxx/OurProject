package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.LoginVo;
import com.cskaoyan.mall.admin.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/admin/auth")
public class  AuthController {

    @Autowired
    AdminService adminService;

    Subject subject;

    @RequestMapping("login")
    public BaseResponseVo login(@RequestBody  LoginVo loginVo){
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //设置携带了用户信息的token
         subject = SecurityUtils.getSubject();
        try {
            //进入到reaml域中进行认证
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseResponseVo.fail("登录失败",500);
        }
        Serializable id = subject.getSession().getId();
        return BaseResponseVo.ok(id);
    }

    @RequestMapping("info")
    public BaseResponseVo info(String token){
        String username = (String) subject.getPrincipal();
        UserInfo userInfo =  adminService.queryAdminInfo(username);
        BaseResponseVo ok = BaseResponseVo.ok(userInfo);
        return ok;
    }
    @RequestMapping("logout")
    public BaseResponseVo logout(){
        subject.logout();
        BaseResponseVo<Object> baseResponseVo = new BaseResponseVo<>();
        baseResponseVo.setErrmsg("成功");
        baseResponseVo.setErrno(0);
        return baseResponseVo;
    }
}
