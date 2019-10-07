package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.vo.CatalogCurrentVo;
import com.cskaoyan.mall.wx.vo.CatalogIndexVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("wx/catalog")
public class CatalogController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("index")
    public BaseResponseVo index(){
        CatalogIndexVo catalogIndex = categoryService.getCatalogIndex();
        BaseResponseVo ok = BaseResponseVo.ok(catalogIndex);
        return ok;
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    public BaseResponseVo current(@Param("id") Integer id){
       CatalogCurrentVo catalogcurrent = categoryService.getCatalogCurrent(id);
        BaseResponseVo ok = BaseResponseVo.ok(catalogcurrent);
        return ok;
    }

}
