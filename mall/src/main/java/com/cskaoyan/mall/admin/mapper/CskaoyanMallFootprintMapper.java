package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFootprint;
import com.cskaoyan.mall.admin.bean.CskaoyanMallFootprintExample;
import java.util.List;

import com.cskaoyan.mall.wx.vo.FootData;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallFootprintMapper {
    long countByExample(CskaoyanMallFootprintExample example);

    int deleteByExample(CskaoyanMallFootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallFootprint record);

    int insertSelective(CskaoyanMallFootprint record);

    List<CskaoyanMallFootprint> selectByExample(CskaoyanMallFootprintExample example);

    CskaoyanMallFootprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallFootprint record, @Param("example") CskaoyanMallFootprintExample example);

    int updateByExample(@Param("record") CskaoyanMallFootprint record, @Param("example") CskaoyanMallFootprintExample example);

    int updateByPrimaryKeySelective(CskaoyanMallFootprint record);

    int updateByPrimaryKey(CskaoyanMallFootprint record);

    List<FootData> selectFootprint();

}