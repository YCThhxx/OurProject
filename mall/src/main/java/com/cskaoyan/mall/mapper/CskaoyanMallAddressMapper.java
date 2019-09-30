package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallAddress;

public interface CskaoyanMallAddressMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallAddress record);

    int updateByPrimaryKey(CskaoyanMallAddress record);
}