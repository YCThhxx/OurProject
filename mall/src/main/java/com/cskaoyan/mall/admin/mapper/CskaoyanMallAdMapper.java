package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CskaoyanMallAdMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallAd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallAd record);

    int updateByPrimaryKey(CskaoyanMallAd record);

    List<CskaoyanMallAd> selectByPageAndPageSize(@Param("adName")String adName,@Param("adContent")String adContent);

    void insertSelective(CskaoyanMallAd ad);

    void insertAd(@Param("ad") CskaoyanMallAd ad);

    @Select("select id,name,link,url,position,content,enabled,add_time as addTime,update_time as updateTime,deleted from cskaoyan_mall_ad where enabled=1 and deleted=0")
    List<CskaoyanMallAd> selectAdList();
}
