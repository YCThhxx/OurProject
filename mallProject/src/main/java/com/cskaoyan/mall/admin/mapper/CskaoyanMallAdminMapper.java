package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;

public interface CskaoyanMallAdminMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallAdmin record);

    int updateByPrimaryKey(CskaoyanMallAdmin record);
}