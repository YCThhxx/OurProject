package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsSpecification;

public interface CskaoyanMallGoodsSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGoodsSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsSpecification record);

    int updateByPrimaryKey(CskaoyanMallGoodsSpecification record);
}