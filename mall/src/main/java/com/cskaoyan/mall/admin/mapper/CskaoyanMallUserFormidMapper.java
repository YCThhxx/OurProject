package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUserFormid;
import com.cskaoyan.mall.admin.bean.CskaoyanMallUserFormidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallUserFormidMapper {
    long countByExample(CskaoyanMallUserFormidExample example);

    int deleteByExample(CskaoyanMallUserFormidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallUserFormid record);

    int insertSelective(CskaoyanMallUserFormid record);

    List<CskaoyanMallUserFormid> selectByExample(CskaoyanMallUserFormidExample example);

    CskaoyanMallUserFormid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallUserFormid record, @Param("example") CskaoyanMallUserFormidExample example);

    int updateByExample(@Param("record") CskaoyanMallUserFormid record, @Param("example") CskaoyanMallUserFormidExample example);

    int updateByPrimaryKeySelective(CskaoyanMallUserFormid record);

    int updateByPrimaryKey(CskaoyanMallUserFormid record);
}