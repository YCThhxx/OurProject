package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsProduct;

public interface CskaoyanMallGoodsProductMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGoodsProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsProduct record);

    int updateByPrimaryKey(CskaoyanMallGoodsProduct record);
}