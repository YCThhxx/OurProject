package com.cskaoyan.mall.marketmanager.controller;

import com.cskaoyan.mall.marketmanager.service.BrandService;
import com.cskaoyan.mall.vo.BaseRespVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseRespVo viewBrand(@Param("page") int page,
                                @Param("limit") int limit,
                                @Param("sort") String sort,
                                @Param("order") String desc){
        BaseRespVo<Object> result = new BaseRespVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
//        brandService.findAllBrandByPage()
        return null;
    }


}
