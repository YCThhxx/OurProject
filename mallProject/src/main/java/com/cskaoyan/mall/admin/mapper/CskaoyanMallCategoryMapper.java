package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;

public interface CskaoyanMallCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCategory record);

    int updateByPrimaryKey(CskaoyanMallCategory record);
}