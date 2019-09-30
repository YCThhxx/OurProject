package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;

public interface CskaoyanMallKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallKeyword record);

    int updateByPrimaryKey(CskaoyanMallKeyword record);
}