package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallPermission;

public interface CskaoyanMallPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallPermission record);

    int updateByPrimaryKey(CskaoyanMallPermission record);
}