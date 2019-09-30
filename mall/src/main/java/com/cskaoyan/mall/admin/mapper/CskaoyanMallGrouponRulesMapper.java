package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;

public interface CskaoyanMallGrouponRulesMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallGrouponRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallGrouponRules record);

    int updateByPrimaryKey(CskaoyanMallGrouponRules record);
}