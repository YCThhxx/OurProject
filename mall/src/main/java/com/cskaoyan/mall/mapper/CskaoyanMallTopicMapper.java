package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallTopic;

public interface CskaoyanMallTopicMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallTopic record);

    int updateByPrimaryKeyWithBLOBs(CskaoyanMallTopic record);

    int updateByPrimaryKey(CskaoyanMallTopic record);
}