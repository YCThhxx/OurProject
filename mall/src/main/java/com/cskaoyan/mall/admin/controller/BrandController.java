package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.BrandService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
                                    @Param("sort") String sort, @Param("order") String order,
                                    @Param("id") Integer id,@Param("name") String name){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        PageBean branddata = brandService.findAllBrandByPage(page,limit,sort,order,id,name);
        result.setData(branddata);
        return result;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public BaseResponseVo addBrand(@RequestBody CskaoyanMallBrand cskaoyanData){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        CskaoyanMallBrand data = brandService.addBrand(cskaoyanData);
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResponseVo updateBrand(@RequestBody CskaoyanMallBrand categoryData){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
         brandService.updateBrand(categoryData);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public BaseResponseVo deleteBrand(@RequestBody CskaoyanMallBrand categoryData){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        brandService.deleteBrand(categoryData);
        return result;
    }

}
