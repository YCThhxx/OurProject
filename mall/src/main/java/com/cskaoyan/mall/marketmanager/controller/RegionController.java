package com.cskaoyan.mall.marketmanager.controller;

import com.cskaoyan.mall.marketmanager.dto.RegionInfo;
import com.cskaoyan.mall.marketmanager.service.RegionService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * 商场管理行政区域
 */

@RestController
@RequestMapping("admin/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    /**
     * 获取行政区域
     * @return
     */
    @GetMapping("/list")
    public BaseRespVo getRegion(){
        System.out.println("hh");
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        List<RegionInfo> allRegion = regionService.findAllRegion();
        objectBaseRespVo.setData(allRegion);
        objectBaseRespVo.setErrmsg("成功");
        objectBaseRespVo.setErrno(0);
        return objectBaseRespVo;
    }

}
