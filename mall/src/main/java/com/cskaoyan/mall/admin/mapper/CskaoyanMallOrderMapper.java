package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallOrder;

public interface CskaoyanMallOrderMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallOrder record);

    int updateByPrimaryKey(CskaoyanMallOrder record);
}