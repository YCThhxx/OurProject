package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.bean.PageBean;

public interface GoodsService {

    PageBean getListOfGoods(int page, int limit, String sort, String order, String goodsSn, String name);

}
