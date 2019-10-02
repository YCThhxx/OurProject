package com.cskaoyan.mall.admin.service;


import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.vo.CatAndBrandInfo;
import com.cskaoyan.mall.admin.vo.GoodsDetailInfo;

public interface GoodsService {

    PageBean getListOfGoods(int page, int limit, String sort, String order, String goodsSn, String name);

    CatAndBrandInfo getListOfCatAndBrand();

    GoodsDetailInfo getDetailOfGoodsById(int id);

    boolean deleteGoodsById(Integer id);

    boolean updateGoods(GoodsDetailInfo goodsDetailInfo);

    void createGoods(GoodsDetailInfo goodsDetailInfo);
}
