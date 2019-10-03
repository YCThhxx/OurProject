package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorageExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallStorageMapper {
    long countByExample(CskaoyanMallStorageExample example);

    int deleteByExample(CskaoyanMallStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallStorage record);

    int insertSelective(CskaoyanMallStorage record);

    List<CskaoyanMallStorage> selectByExample(CskaoyanMallStorageExample example);

    CskaoyanMallStorage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallStorage record, @Param("example") CskaoyanMallStorageExample example);

    int updateByExample(@Param("record") CskaoyanMallStorage record, @Param("example") CskaoyanMallStorageExample example);

    int updateByPrimaryKeySelective(CskaoyanMallStorage record);

    int updateByPrimaryKey(CskaoyanMallStorage record);

    long countAllStorage();

    void delete(Integer id);

    List<CskaoyanMallStorage> queryAllStorageEqualKeyLikeName(@Param("key") String key,
                                                              @Param("name") String name,
                                                              @Param("sort") String sort,
                                                              @Param("order") String order);

    CskaoyanMallStorage queryStorageById(Integer id);
}
