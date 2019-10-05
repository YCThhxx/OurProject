package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CskaoyanMallTopicMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallTopic record);

    int updateByPrimaryKeyWithBLOBs(CskaoyanMallTopic record);

    int updateByPrimaryKey(CskaoyanMallTopic record);

    List<CskaoyanMallTopic> selectByPageAndPageSize(String title, String subtitle);

    void insertTopic(@Param("t") CskaoyanMallTopic topic);
}