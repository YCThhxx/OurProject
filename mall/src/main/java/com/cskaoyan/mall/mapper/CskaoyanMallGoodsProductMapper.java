package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallGoodsProduct;

public interface CskaoyanMallGoodsProductMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGoodsProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsProduct record);

    int updateByPrimaryKey(CskaoyanMallGoodsProduct record);
}