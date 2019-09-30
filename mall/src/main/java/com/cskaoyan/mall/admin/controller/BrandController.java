package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
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
    public BaseResponseVo viewBrand(@Param("page") int page, @Param("limit") int limit,
                                    @Param("sort") String sort, @Param("order") String order){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        PageBean branddata = brandService.findAllBrandByPage(page,limit,sort,order);
        result.setData(branddata);
        return result;
    }

}
