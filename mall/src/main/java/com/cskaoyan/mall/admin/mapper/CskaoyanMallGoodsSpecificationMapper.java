package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsSpecification;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallGoodsSpecificationMapper {
    long countByExample(CskaoyanMallGoodsSpecificationExample example);

    int deleteByExample(CskaoyanMallGoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallGoodsSpecification record);

    int insertSelective(CskaoyanMallGoodsSpecification record);

    List<CskaoyanMallGoodsSpecification> selectByExample(CskaoyanMallGoodsSpecificationExample example);

    CskaoyanMallGoodsSpecification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallGoodsSpecification record, @Param("example") CskaoyanMallGoodsSpecificationExample example);

    int updateByExample(@Param("record") CskaoyanMallGoodsSpecification record, @Param("example") CskaoyanMallGoodsSpecificationExample example);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsSpecification record);

    int updateByPrimaryKey(CskaoyanMallGoodsSpecification record);
}