package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallRegion;

public interface CskaoyanMallRegionMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallRegion record);

    int updateByPrimaryKey(CskaoyanMallRegion record);
}