package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.bean.CskaoyanMallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallUserMapper {
    long countByExample(CskaoyanMallUserExample example);

    int deleteByExample(CskaoyanMallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallUser record);

    int insertSelective(CskaoyanMallUser record);

    List<CskaoyanMallUser> selectByExample(CskaoyanMallUserExample example);

    CskaoyanMallUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallUser record, @Param("example") CskaoyanMallUserExample example);

    int updateByExample(@Param("record") CskaoyanMallUser record, @Param("example") CskaoyanMallUserExample example);

    int updateByPrimaryKeySelective(CskaoyanMallUser record);

    int updateByPrimaryKey(CskaoyanMallUser record);
}