package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpressController {

    /*@RequestMapping("list")
    public BaseRespVo addressList(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId = userService.selectByUsername(username);
        List<CskaoyanMallAddress> data = addressService.selectAddressList(userId);
        return BaseRespVo.ok(data);
    }*/
}
