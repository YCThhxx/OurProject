package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.wx.vo.goodsvo.CategoryVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsDetailVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsListVo;

import java.util.List;

public interface WxGoodsService {

    int goodsCount();

    CategoryVo goodsCategory(int id);

    GoodsDetailVo goodsDetail(Integer userid ,int id);

    List<CskaoyanMallGoods> selectRelated(int id);

    GoodsListVo getList(String name , int page, int size, String sort, String order, Integer brandId, String keyword, Integer categoryId);

}
