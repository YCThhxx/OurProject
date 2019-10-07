package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallBrandMapper;
import com.cskaoyan.mall.admin.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    CskaoyanMallBrandMapper cskaoyanMallBrandMapper;


    @Override
    public PageBean findAllBrandByPage(int page, int limit, String sort, String order,Integer id,String name) {
        String orderBy = sort +" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List brandList =  cskaoyanMallBrandMapper.findAllBrandByPage(id,name);
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(brandList);
        PageInfo<CskaoyanMallBrand> pageInfo = new PageInfo<>(brandList);
        long total = pageInfo.getTotal();
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public CskaoyanMallBrand addBrand(CskaoyanMallBrand cskaoyanData) {
        Date addTime = new Date();
        cskaoyanData.setAddTime(addTime);
        cskaoyanData.setUpdateTime(addTime);
        cskaoyanData.setDeleted(false);
        int id = cskaoyanMallBrandMapper.insert(cskaoyanData);
        cskaoyanData.setId(id);
        return cskaoyanData;
    }

    @Override
    public boolean updateBrand(CskaoyanMallBrand categoryData) {
        Date date = new Date();
        categoryData.setUpdateTime(date);
        int i = cskaoyanMallBrandMapper.updateByPrimaryKey(categoryData);
        if(i != 0){
            return true;
        }
        return false;
    }



    @Override
    public boolean deleteBrand(CskaoyanMallBrand categoryData) {
        int i = cskaoyanMallBrandMapper.deleteBrand(categoryData);
        if(i != 0){
            return true;
        }
        return false;
    }


}
