package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallCollect;

public interface CskaoyanMallCollectMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCollect record);

    int updateByPrimaryKey(CskaoyanMallCollect record);
}