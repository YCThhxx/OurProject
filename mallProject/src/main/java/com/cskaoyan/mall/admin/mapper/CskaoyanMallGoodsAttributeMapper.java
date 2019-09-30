package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsAttribute;

public interface CskaoyanMallGoodsAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGoodsAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsAttribute record);

    int updateByPrimaryKey(CskaoyanMallGoodsAttribute record);
}