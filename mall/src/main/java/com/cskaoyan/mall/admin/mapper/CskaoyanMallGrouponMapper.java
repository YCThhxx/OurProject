package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallGrouponMapper {
    long countByExample(CskaoyanMallGrouponExample example);

    int deleteByExample(CskaoyanMallGrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallGroupon record);

    int insertSelective(CskaoyanMallGroupon record);

    List<CskaoyanMallGroupon> selectByExample(CskaoyanMallGrouponExample example);

    CskaoyanMallGroupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallGroupon record, @Param("example") CskaoyanMallGrouponExample example);

    int updateByExample(@Param("record") CskaoyanMallGroupon record, @Param("example") CskaoyanMallGrouponExample example);

    int updateByPrimaryKeySelective(CskaoyanMallGroupon record);

    int updateByPrimaryKey(CskaoyanMallGroupon record);

    List<CskaoyanMallGroupon> selectAllGrouponsByAddtime(@Param("by") String addtime,
                                                        @Param("order") String order);

    List<CskaoyanMallGroupon> selectAllGrouponsByRulesId(@Param("rulesId") int ruledId);

    long countAllGroupons();
}
