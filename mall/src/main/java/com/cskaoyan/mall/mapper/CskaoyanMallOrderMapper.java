package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallOrder;

public interface CskaoyanMallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallOrder record);

    int updateByPrimaryKey(CskaoyanMallOrder record);
}