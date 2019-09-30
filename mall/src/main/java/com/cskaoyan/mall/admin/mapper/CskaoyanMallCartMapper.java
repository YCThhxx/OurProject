package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;

public interface CskaoyanMallCartMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCart record);

    int updateByPrimaryKey(CskaoyanMallCart record);
}