package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallFootprint;

public interface CskaoyanMallFootprintMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallFootprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallFootprint record);

    int updateByPrimaryKey(CskaoyanMallFootprint record);
}