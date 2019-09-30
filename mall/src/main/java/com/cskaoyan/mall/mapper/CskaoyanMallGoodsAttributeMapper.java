package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallGoodsAttribute;

public interface CskaoyanMallGoodsAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGoodsAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsAttribute record);

    int updateByPrimaryKey(CskaoyanMallGoodsAttribute record);
}