package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.bean.PageBean;

public interface BrandService {

     PageBean findAllBrandByPage(int page, int limit, String sort, String order);



}
