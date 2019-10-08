package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFootprint;
import com.cskaoyan.mall.wx.service.FootprintService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import com.cskaoyan.mall.wx.vo.FootprintData;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FootprintController {

    @Autowired
    FootprintService footprintService;
    @Autowired
    WxUserService wxUserService;

    @GetMapping("/wx/footprint/list")
    public BaseRespVo footprint(@RequestParam("page") int page,
                                @RequestParam("size") int size){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        FootprintData data = footprintService.getFootprint(page,size,userId);
        return BaseRespVo.ok(data);
    }

}
