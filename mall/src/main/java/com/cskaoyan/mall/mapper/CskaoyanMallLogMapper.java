package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallLog;

public interface CskaoyanMallLogMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallLog record);

    int updateByPrimaryKey(CskaoyanMallLog record);
}