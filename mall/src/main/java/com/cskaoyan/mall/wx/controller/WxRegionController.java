package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;
import com.cskaoyan.mall.wx.service.AddressService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/region")
public class WxRegionController {
    @Autowired
    AddressService addressService;

    @GetMapping("list")
    public BaseRespVo regionList(@Param("pid") int pid){
        List<CskaoyanMallRegion> data = addressService.selectRegionList(pid);
        return BaseRespVo.ok(data);
    }
}
