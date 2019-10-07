package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsAttribute;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallGoodsAttributeMapper {
    long countByExample(CskaoyanMallGoodsAttributeExample example);

    int deleteByExample(CskaoyanMallGoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallGoodsAttribute record);

    int insertSelective(CskaoyanMallGoodsAttribute record);

    List<CskaoyanMallGoodsAttribute> selectByExample(CskaoyanMallGoodsAttributeExample example);

    CskaoyanMallGoodsAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallGoodsAttribute record, @Param("example") CskaoyanMallGoodsAttributeExample example);

    int updateByExample(@Param("record") CskaoyanMallGoodsAttribute record, @Param("example") CskaoyanMallGoodsAttributeExample example);

    int updateByPrimaryKeySelective(CskaoyanMallGoodsAttribute record);

    int updateByPrimaryKey(CskaoyanMallGoodsAttribute record);

    List<CskaoyanMallGoodsAttribute> selectByGoodsId(int id);
}
