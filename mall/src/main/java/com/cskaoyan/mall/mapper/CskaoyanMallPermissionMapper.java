package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallPermission;

public interface CskaoyanMallPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallPermission record);

    int updateByPrimaryKey(CskaoyanMallPermission record);
}