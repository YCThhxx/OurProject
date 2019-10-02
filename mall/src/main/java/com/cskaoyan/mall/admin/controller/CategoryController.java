package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponseVo viewCategory(){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        List<CategoryData> data = categoryService.getCategory();
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "l1",method = RequestMethod.GET)
    public BaseResponseVo getCategoryLevel1(){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        List<L1Data> data = categoryService.getCategoryLevel1();
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResponseVo updateCategory(@RequestBody CskaoyanMallCategory categoryData){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
         categoryService.updateCategory(categoryData);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public BaseResponseVo deleteCategory(@RequestBody CskaoyanMallCategory categoryData){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        categoryService.deleteCategory(categoryData);
        return result;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public BaseResponseVo addCategory(@RequestBody CskaoyanMallCategory cskaoyanData){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        CskaoyanMallCategory data = categoryService.addCategory(cskaoyanData);
        result.setData(data);
        return result;
    }
}
