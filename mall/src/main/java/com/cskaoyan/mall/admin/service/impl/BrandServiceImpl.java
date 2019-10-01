package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallBrandMapper;
import com.cskaoyan.mall.admin.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    CskaoyanMallBrandMapper cskaoyanMallBrandMapper;


    @Override
    public PageBean findAllBrandByPage(int page, int limit, String sort, String order) {
        String orderBy = sort +" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List brandList =  cskaoyanMallBrandMapper.findAllBrandByPage();
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(brandList);
        PageInfo<CskaoyanMallBrand> pageInfo = new PageInfo<>(brandList);
        long total = pageInfo.getTotal();
        pageBean.setTotal(total);
        return pageBean;
    }

}
