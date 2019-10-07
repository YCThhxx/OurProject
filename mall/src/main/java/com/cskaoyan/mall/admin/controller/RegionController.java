package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.RegionData;
import com.cskaoyan.mall.wx.service.AddressService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RegionController {

    @Autowired
    RegionService regionService;

    @GetMapping(value = "/admin/region/list")
    public BaseResponseVo viewRegion(){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        List<RegionData> data= regionService.getRegions();
        result.setData(data);
        return result;
    }

}
