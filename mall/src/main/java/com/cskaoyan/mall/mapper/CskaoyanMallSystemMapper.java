package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallSystem;

public interface CskaoyanMallSystemMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallSystem record);

    int updateByPrimaryKey(CskaoyanMallSystem record);
}