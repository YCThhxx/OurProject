package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallPermission;
import com.cskaoyan.mall.admin.bean.CskaoyanMallPermissionExample;
import com.cskaoyan.mall.admin.vo.permissionvo.SystemPermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    List<SystemPermissionVo> querySystempermissionsList();

    List<SystemPermissionVo> querySystempermissionsChildrenList(int pid);

    List<String> queryAllPermissions();

    void updatePermission(@Param("id") int id,
                          @Param("permission") String permission,
                          @Param("add_time") Date add_time,
                          @Param("update_time") Date update_time);

    void deleteByRoleId(int id);

    String queryPermissionsApi(String permission);

}
