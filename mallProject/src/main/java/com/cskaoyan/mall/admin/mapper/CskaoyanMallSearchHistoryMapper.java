package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallSearchHistory;

public interface CskaoyanMallSearchHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallSearchHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallSearchHistory record);

    int updateByPrimaryKey(CskaoyanMallSearchHistory record);
}