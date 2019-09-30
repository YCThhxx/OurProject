package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCollect;

public interface CskaoyanMallCollectMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCollect record);

    int updateByPrimaryKey(CskaoyanMallCollect record);
}