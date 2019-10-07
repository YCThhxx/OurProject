package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.vo.goodsvo.CategoryVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsDetailVo;

public interface WxGoodsService {

    int goodsCount();

    CategoryVo goodsCategory(int id);

    GoodsDetailVo goodsDetail(Integer userid ,int id);
}
