package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallRegionMapper {
    long countByExample(CskaoyanMallRegionExample example);

    int deleteByExample(CskaoyanMallRegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallRegion record);

    int insertSelective(CskaoyanMallRegion record);

    List<CskaoyanMallRegion> selectByExample(CskaoyanMallRegionExample example);

    CskaoyanMallRegion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallRegion record, @Param("example") CskaoyanMallRegionExample example);

    int updateByExample(@Param("record") CskaoyanMallRegion record, @Param("example") CskaoyanMallRegionExample example);

    int updateByPrimaryKeySelective(CskaoyanMallRegion record);

    int updateByPrimaryKey(CskaoyanMallRegion record);
}