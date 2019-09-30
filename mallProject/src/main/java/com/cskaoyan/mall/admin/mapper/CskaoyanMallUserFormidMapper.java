package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUserFormid;

public interface CskaoyanMallUserFormidMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallUserFormid selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallUserFormid record);

    int updateByPrimaryKey(CskaoyanMallUserFormid record);
}