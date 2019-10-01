package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallSearchHistory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallSearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallSearchHistoryMapper {
    long countByExample(CskaoyanMallSearchHistoryExample example);

    int deleteByExample(CskaoyanMallSearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallSearchHistory record);

    int insertSelective(CskaoyanMallSearchHistory record);

    List<CskaoyanMallSearchHistory> selectByExample(CskaoyanMallSearchHistoryExample example);

    CskaoyanMallSearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallSearchHistory record, @Param("example") CskaoyanMallSearchHistoryExample example);

    int updateByExample(@Param("record") CskaoyanMallSearchHistory record, @Param("example") CskaoyanMallSearchHistoryExample example);

    int updateByPrimaryKeySelective(CskaoyanMallSearchHistory record);

    int updateByPrimaryKey(CskaoyanMallSearchHistory record);
}