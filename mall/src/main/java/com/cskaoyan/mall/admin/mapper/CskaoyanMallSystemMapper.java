package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallSystem;
import com.cskaoyan.mall.admin.bean.CskaoyanMallSystemExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallSystemMapper {
    long countByExample(CskaoyanMallSystemExample example);

    int deleteByExample(CskaoyanMallSystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallSystem record);

    int insertSelective(CskaoyanMallSystem record);

    List<CskaoyanMallSystem> selectByExample(CskaoyanMallSystemExample example);

    CskaoyanMallSystem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallSystem record, @Param("example") CskaoyanMallSystemExample example);

    int updateByExample(@Param("record") CskaoyanMallSystem record, @Param("example") CskaoyanMallSystemExample example);

    int updateByPrimaryKeySelective(CskaoyanMallSystem record);

    int updateByPrimaryKey(CskaoyanMallSystem record);

    public void updateConfigInfo(@Param("keyName") String keyName,
                                 @Param("keyValue") String keyValue,
                                 @Param("date") Date date);

    public List<CskaoyanMallSystem> selectAll();
}
