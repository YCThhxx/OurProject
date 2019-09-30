package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallGoodsSpecification;

public interface CskaoyanMallGoodsSpecificationMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGoodsSpecification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsSpecification record);

    int updateByPrimaryKey(CskaoyanMallGoodsSpecification record);
}