package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.CskaoyanMallAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallAdMapper {
    long countByExample(CskaoyanMallAdExample example);

    int deleteByExample(CskaoyanMallAdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallAd record);

    int insertSelective(CskaoyanMallAd record);

    List<CskaoyanMallAd> selectByExample(CskaoyanMallAdExample example);

    CskaoyanMallAd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallAd record, @Param("example") CskaoyanMallAdExample example);

    int updateByExample(@Param("record") CskaoyanMallAd record, @Param("example") CskaoyanMallAdExample example);

    int updateByPrimaryKeySelective(CskaoyanMallAd record);

    int updateByPrimaryKey(CskaoyanMallAd record);
}