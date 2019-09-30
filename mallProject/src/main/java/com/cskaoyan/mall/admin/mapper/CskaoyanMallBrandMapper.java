package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;

public interface CskaoyanMallBrandMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallBrand record);

    int updateByPrimaryKey(CskaoyanMallBrand record);
}