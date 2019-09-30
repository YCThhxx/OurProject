package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallRole;

public interface CskaoyanMallRoleMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallRole record);

    int updateByPrimaryKey(CskaoyanMallRole record);
}