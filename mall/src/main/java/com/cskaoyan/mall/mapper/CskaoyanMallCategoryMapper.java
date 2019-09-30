package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallCategory;

public interface CskaoyanMallCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCategory record);

    int updateByPrimaryKey(CskaoyanMallCategory record);
}