package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRole;

public interface CskaoyanMallRoleMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallRole record);

    int updateByPrimaryKey(CskaoyanMallRole record);
}