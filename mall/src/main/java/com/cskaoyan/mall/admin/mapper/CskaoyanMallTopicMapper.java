package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CskaoyanMallTopicMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallTopic record);

    int updateByPrimaryKeyWithBLOBs(CskaoyanMallTopic record);

    int updateByPrimaryKey(CskaoyanMallTopic record);

    List<CskaoyanMallTopic> selectByPageAndPageSize(String title, String subtitle);

    void insertTopic(@Param("t") CskaoyanMallTopic topic);

    @Select("select id,title,subtitle,price,read_count as readCount,pic_url as picUrl from cskaoyan_mall_topic limit #{limit}")
    List<CskaoyanMallTopic> selectTopic(@Param("limit") int limit);

    List<CskaoyanMallTopic> selectAll();

    List<CskaoyanMallTopic> selectRelated(int id);
}
