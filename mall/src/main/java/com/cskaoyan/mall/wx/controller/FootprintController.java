package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFootprint;
import com.cskaoyan.mall.wx.service.FootprintService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import com.cskaoyan.mall.wx.vo.FootprintData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FootprintController {

    @Autowired
    FootprintService footprintService;

    @GetMapping("/wx/footprint/list")
    public BaseRespVo footprint(@RequestParam("page") int page,
                                @RequestParam("size") int size){
        FootprintData data = footprintService.getFootprint(page,size);
        return BaseRespVo.ok(data);
    }

}
