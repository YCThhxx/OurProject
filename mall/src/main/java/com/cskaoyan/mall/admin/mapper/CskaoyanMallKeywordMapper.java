package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;

import java.util.List;

public interface CskaoyanMallKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallKeyword record);

    int updateByPrimaryKey(CskaoyanMallKeyword record);

    List<CskaoyanMallKeyword> showKeyByPage();

    int addKeyWord(CskaoyanMallKeyword record);
}