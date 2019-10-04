package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CskaoyanMallAdMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallAd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallAd record);

    int updateByPrimaryKey(CskaoyanMallAd record);

    List<CskaoyanMallAd> selectByPageAndPageSize(@Param("adName")String adName,@Param("adContent")String adContent);

    void insertSelective(CskaoyanMallAd ad);

    void insertAd(@Param("ad") CskaoyanMallAd ad);
}
