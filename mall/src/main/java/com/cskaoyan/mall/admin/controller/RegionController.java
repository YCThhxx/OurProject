package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.RegionData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponseVo viewRegion(){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        List<RegionData> data= regionService.getRegions();
        result.setData(data);
        return result;
    }
}
