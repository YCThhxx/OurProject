package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.PageBean;

public interface BrandService {

     PageBean findAllBrandByPage(int page, int limit, String sort, String order,Integer id,String name);


     CskaoyanMallBrand addBrand(CskaoyanMallBrand cskaoyanData);

     boolean updateBrand(CskaoyanMallBrand categoryData);

     boolean deleteBrand(CskaoyanMallBrand categoryData);
}
