package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallKeyword;

public interface CskaoyanMallKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallKeyword record);

    int updateByPrimaryKey(CskaoyanMallKeyword record);
}