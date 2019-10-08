package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRole;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.vo.OptionVo;
import com.cskaoyan.mall.admin.vo.permissionvo.SystemPermissionVo;

import java.util.List;

public interface SystemManageService {
    List<CskaoyanMallStorage> storageList(int page, int limit, String key, String name, String sort, String order);
    long countAllStorage();

    List<CskaoyanMallAdmin> adminList(int page, int limit, String username, String sort, String order);
    long countAllAdmin();

    List<OptionVo> options();

    List<CskaoyanMallLog> logList(int page, int limit, String name, String sort, String order);

    long countAllLog();

    List<CskaoyanMallRole> roleList(int page, int limit, String name, String sort, String order);

    long countAllRole();

    CskaoyanMallStorage create(String newname, String filename, String type, int size, String url);

    boolean deleteStorage(Integer id);

    CskaoyanMallAdmin createAdmin(CskaoyanMallAdmin admin);

    boolean deleteAdmin(Integer id);

    void updateAdmin(CskaoyanMallAdmin admin);

    CskaoyanMallAdmin queryAdminById(Integer id);

    CskaoyanMallRole createRole(CskaoyanMallRole role);

    void updateRole(CskaoyanMallRole role);

    CskaoyanMallRole queryRoleById(Integer id);

    boolean deleteRole(Integer id);

    void updateStorage(CskaoyanMallStorage storage);

    CskaoyanMallStorage queryStorageById(Integer id);

    List<SystemPermissionVo> systempermissionsList();

    List<String> queryPermissionsByRoleId(int roleId);

    void updatePermissions(int roleId, List<String> permissions);
}
