package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;

public interface CskaoyanMallRegionMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallRegion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallRegion record);

    int updateByPrimaryKey(CskaoyanMallRegion record);
}