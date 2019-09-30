package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallSystem;

public interface CskaoyanMallSystemMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallSystem record);

    int updateByPrimaryKey(CskaoyanMallSystem record);
}