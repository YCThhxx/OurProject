package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallSearchHistory;

public interface CskaoyanMallSearchHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallSearchHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallSearchHistory record);

    int updateByPrimaryKey(CskaoyanMallSearchHistory record);
}