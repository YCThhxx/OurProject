package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CskaoyanMallStorageMapper {

    List<CskaoyanMallStorage> queryStorage();

    int deleteByPrimaryKey(Integer id);

    CskaoyanMallStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallStorage record);

    int updateByPrimaryKey(CskaoyanMallStorage record);

    int countAll();
}
