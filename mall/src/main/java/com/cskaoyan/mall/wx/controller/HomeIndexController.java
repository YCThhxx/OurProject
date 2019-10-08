package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.HomeService;
import com.cskaoyan.mall.wx.vo.homeIndex.HomeInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("wx")
public class HomeIndexController {

    @Autowired
    HomeService homeService;

    Subject subject;

    @RequestMapping("home/index")
    public BaseResponseVo home(){
        HomeInfo homeInfo = homeService.selectHomeIndexMsg();
        BaseResponseVo ok = BaseResponseVo.ok(homeInfo);
        return ok;
    }

}
