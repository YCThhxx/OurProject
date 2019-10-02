package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.service.CfService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.configvo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/config")
public class ConfigController {

    @Autowired
    CfService cfService;

    @GetMapping("mall")
    public BaseResponseVo mallGetConfig(){
        MallConfigVo configVo = cfService.getMallConfig();
        BaseResponseVo ok = BaseResponseVo.ok(configVo);
        return ok;
    }

    @GetMapping("express")
    public BaseResponseVo expressGetConfig(){
        ExpressConfigVo configVo = cfService.getExpressConfig();
        BaseResponseVo ok = BaseResponseVo.ok(configVo);
        return ok;
    }

    @GetMapping("order")
    public BaseResponseVo orderGetConfig(){
        OrderConfigVo configVo = cfService.getOrderConfig();
        BaseResponseVo ok = BaseResponseVo.ok(configVo);
        return ok;
    }

    @GetMapping("wx")
    public BaseResponseVo wxGetConfig(){
        WxConfigVo configVo = cfService.getWxConfig();
        BaseResponseVo ok = BaseResponseVo.ok(configVo);
        return ok;
    }

    @PostMapping("mall")
    public BaseResponseVo mallPostConfig(@RequestBody MallConfigVo configVo){
        cfService.mallPostConfig(configVo);
        BaseResponseVo ok = BaseResponseVo.ok();
        return ok;
    }

    @PostMapping("express")
    public BaseResponseVo expressPostConfig(@RequestBody ExpressConfigVo configVo){
        cfService.expressPostConfig(configVo);
        BaseResponseVo ok = BaseResponseVo.ok();
        return ok;
    }

    @PostMapping("order")
    public BaseResponseVo orderPostConfig(@RequestBody OrderConfigVo configVo){
        cfService.orderPostConfig(configVo);
        BaseResponseVo ok = BaseResponseVo.ok();
        return ok;
    }

    @PostMapping("wx")
    public BaseResponseVo wxPostConfig(@RequestBody WxConfigVo configVo){
        cfService.wxPostConfig(configVo);
        BaseResponseVo ok = BaseResponseVo.ok();
        return ok;
    }
}
