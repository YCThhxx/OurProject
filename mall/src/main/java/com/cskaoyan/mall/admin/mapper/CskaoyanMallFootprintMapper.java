package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFootprint;

public interface CskaoyanMallFootprintMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallFootprint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallFootprint record);

    int updateByPrimaryKey(CskaoyanMallFootprint record);
}