package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCollect;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCollectExample;
import java.util.List;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallCollectMapper {
    long countByExample(CskaoyanMallCollectExample example);

    int deleteByExample(CskaoyanMallCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallCollect record);

    int insertSelective(CskaoyanMallCollect record);

    List<CskaoyanMallCollect> selectByExample(CskaoyanMallCollectExample example);

    CskaoyanMallCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallCollect record, @Param("example") CskaoyanMallCollectExample example);

    int updateByExample(@Param("record") CskaoyanMallCollect record, @Param("example") CskaoyanMallCollectExample example);

    int updateByPrimaryKeySelective(CskaoyanMallCollect record);

    int updateByPrimaryKey(CskaoyanMallCollect record);

    int selectHasCollect(@Param("userid") int userid,
                          @Param("id") int id);

    int hasGoods(@Param("valueId") Integer valueId);


}
