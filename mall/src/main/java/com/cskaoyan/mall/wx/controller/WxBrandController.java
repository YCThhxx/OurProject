package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.WxBrandService;
import com.cskaoyan.mall.wx.vo.brandvo.BrandListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/brand")
public class WxBrandController {

    @Autowired
    WxBrandService brandService;

    @RequestMapping("list")
    public BaseResponseVo brandList(int page,int size){
        BrandListVo brandListVo = brandService.brandList(page,size);
        return BaseResponseVo.ok(brandListVo);
    }

    @RequestMapping("detail")
    public BaseResponseVo brandDetail(int id){
        CskaoyanMallBrand brand = brandService.brandDetail(id);
        Map map = new HashMap();
        map.put("brand",brand);
        return BaseResponseVo.ok(map);
    }
}
