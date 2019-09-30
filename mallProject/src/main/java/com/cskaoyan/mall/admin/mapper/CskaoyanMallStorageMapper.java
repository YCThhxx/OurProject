package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;

public interface CskaoyanMallStorageMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallStorage record);

    int updateByPrimaryKey(CskaoyanMallStorage record);
}