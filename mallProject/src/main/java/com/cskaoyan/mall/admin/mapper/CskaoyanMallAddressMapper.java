package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;

public interface CskaoyanMallAddressMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallAddress record);

    int updateByPrimaryKey(CskaoyanMallAddress record);
}