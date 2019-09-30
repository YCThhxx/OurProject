package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallGrouponRules;

public interface CskaoyanMallGrouponRulesMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGrouponRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGrouponRules record);

    int updateByPrimaryKey(CskaoyanMallGrouponRules record);
}