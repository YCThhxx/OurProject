package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;

public interface CskaoyanMallGrouponMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGroupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGroupon record);

    int updateByPrimaryKey(CskaoyanMallGroupon record);
}