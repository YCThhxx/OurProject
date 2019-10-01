package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;
import com.cskaoyan.mall.admin.bean.CskaoyanMallKeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallKeywordMapper {
    long countByExample(CskaoyanMallKeywordExample example);

    int deleteByExample(CskaoyanMallKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallKeyword record);

    int insertSelective(CskaoyanMallKeyword record);

    List<CskaoyanMallKeyword> selectByExample(CskaoyanMallKeywordExample example);

    CskaoyanMallKeyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallKeyword record, @Param("example") CskaoyanMallKeywordExample example);

    int updateByExample(@Param("record") CskaoyanMallKeyword record, @Param("example") CskaoyanMallKeywordExample example);

    int updateByPrimaryKeySelective(CskaoyanMallKeyword record);

    int updateByPrimaryKey(CskaoyanMallKeyword record);
}