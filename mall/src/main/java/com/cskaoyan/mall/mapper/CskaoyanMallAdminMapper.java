package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallAdmin;

public interface CskaoyanMallAdminMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallAdmin record);

    int updateByPrimaryKey(CskaoyanMallAdmin record);
}