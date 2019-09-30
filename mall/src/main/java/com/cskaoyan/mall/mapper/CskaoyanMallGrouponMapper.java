package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallGroupon;

public interface CskaoyanMallGrouponMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGroupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGroupon record);

    int updateByPrimaryKey(CskaoyanMallGroupon record);
}