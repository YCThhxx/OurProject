package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;

public interface CskaoyanMallLogMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallLog record);

    int updateByPrimaryKey(CskaoyanMallLog record);
}