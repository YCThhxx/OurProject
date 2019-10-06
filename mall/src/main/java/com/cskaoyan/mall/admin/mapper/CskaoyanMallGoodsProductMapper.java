package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsProduct;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CskaoyanMallGoodsProductMapper {
    long countByExample(CskaoyanMallGoodsProductExample example);

    int deleteByExample(CskaoyanMallGoodsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallGoodsProduct record);

    int insertSelective(CskaoyanMallGoodsProduct record);

    List<CskaoyanMallGoodsProduct> selectByExample(CskaoyanMallGoodsProductExample example);

    CskaoyanMallGoodsProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallGoodsProduct record, @Param("example") CskaoyanMallGoodsProductExample example);

    int updateByExample(@Param("record") CskaoyanMallGoodsProduct record, @Param("example") CskaoyanMallGoodsProductExample example);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsProduct record);

    int updateByPrimaryKey(CskaoyanMallGoodsProduct record);

    int selectProductTotal();

    List<CskaoyanMallGoodsProduct> selectByGoodsId(int id);
}
