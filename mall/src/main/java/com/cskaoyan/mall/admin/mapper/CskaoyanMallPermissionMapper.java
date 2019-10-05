package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallPermission;
import com.cskaoyan.mall.admin.bean.CskaoyanMallPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CskaoyanMallPermissionMapper {
    long countByExample(CskaoyanMallPermissionExample example);

    int deleteByExample(CskaoyanMallPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallPermission record);

    int insertSelective(CskaoyanMallPermission record);

    List<CskaoyanMallPermission> selectByExample(CskaoyanMallPermissionExample example);

    CskaoyanMallPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallPermission record, @Param("example") CskaoyanMallPermissionExample example);

    int updateByExample(@Param("record") CskaoyanMallPermission record, @Param("example") CskaoyanMallPermissionExample example);

    int updateByPrimaryKeySelective(CskaoyanMallPermission record);

    int updateByPrimaryKey(CskaoyanMallPermission record);

    List<String> queryPermissions(int id);
}