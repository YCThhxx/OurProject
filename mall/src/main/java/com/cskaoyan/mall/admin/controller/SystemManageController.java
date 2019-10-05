package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.ItemsVo;
import com.cskaoyan.mall.admin.vo.OptionVo;
import com.cskaoyan.mall.admin.vo.permissionvo.Permission;
import com.cskaoyan.mall.admin.vo.permissionvo.PermissionVo;
import com.cskaoyan.mall.admin.vo.permissionvo.SystemPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SystemManageController {

    @Autowired
    SystemManageService systemManageService;

    @RequestMapping(value = "admin/storage/list")
    public BaseResponseVo storageList(int page, int limit, String key, String name, String sort, String order){
        List<CskaoyanMallStorage> storages = systemManageService.storageList(page, limit, key, name, sort, order);
        long total = systemManageService.countAllStorage();
        if (storages != null){
            BaseResponseVo ok = ok(storages, total);
            return ok;
        }
        return null;
    }

    @RequestMapping(value = "admin/storage/update")
    public BaseResponseVo updateStorage(@RequestBody CskaoyanMallStorage storage){
        systemManageService.updateStorage(storage);
        CskaoyanMallStorage storage1 = systemManageService.queryStorageById(storage.getId());
        if (storage1 != null){
            BaseResponseVo ok = BaseResponseVo.ok(storage1);
            return ok;
        }
        return null;
    }

    @GetMapping(value = "admin/admin/list")
    public BaseResponseVo adminList(int page, int limit, String username, String sort, String order){
        List<CskaoyanMallAdmin> admins = systemManageService.adminList(page, limit, username, sort, order);
        long total = systemManageService.countAllAdmin();
        if (admins != null){
            BaseResponseVo ok = ok(admins, total);
            return ok;
        }
        return null;
    }

    @PostMapping(value = "admin/admin/create")
    public BaseResponseVo createAdmin(@RequestBody CskaoyanMallAdmin admin){
        CskaoyanMallAdmin admin1 = systemManageService.createAdmin(admin);
        if (admin1 != null){
            BaseResponseVo ok = BaseResponseVo.ok(admin1);
            return ok;
        }
        return null;
    }

    @PostMapping(value = "admin/admin/delete")
    public BaseResponseVo deleteAdmin(@RequestBody CskaoyanMallAdmin admin){
        boolean delete = systemManageService.deleteAdmin(admin.getId());
        if (delete){
            BaseResponseVo ok = BaseResponseVo.ok();
            return ok;
        }
        return null;
    }

    @PostMapping(value = "admin/admin/update")
    public BaseResponseVo updateAdmin(@RequestBody CskaoyanMallAdmin admin){
        systemManageService.updateAdmin(admin);
        CskaoyanMallAdmin admin1 = systemManageService.queryAdminById(admin.getId());
        if (admin1 != null){
            BaseResponseVo ok = BaseResponseVo.ok(admin1);
            return ok;
        }
        return null;
    }

    @RequestMapping("admin/role/options")
    public BaseResponseVo options(){
        List<OptionVo> optionVos = systemManageService.options();
        if (optionVos != null){
            BaseResponseVo ok = BaseResponseVo.ok(optionVos);
            return ok;
        }
        return null;
    }

    @PostMapping("admin/role/create")
    public BaseResponseVo createRole(@RequestBody CskaoyanMallRole role){
        CskaoyanMallRole role1 = systemManageService.createRole(role);
        if (role1 != null){
            BaseResponseVo ok = BaseResponseVo.ok(role1);
            return ok;
        }
        return null;
    }

    @PostMapping("admin/role/update")
    public BaseResponseVo updateRole(@RequestBody CskaoyanMallRole role){
        systemManageService.updateRole(role);
        CskaoyanMallRole role1 = systemManageService.queryRoleById(role.getId());
        if (role1 != null){
            BaseResponseVo ok = BaseResponseVo.ok(role1);
            return ok;
        }
        return null;
    }

    @PostMapping("admin/role/delete")
    public BaseResponseVo deleteRole(@RequestBody CskaoyanMallRole role){
        boolean delete = systemManageService.deleteRole(role.getId());
        if (delete){
            BaseResponseVo ok = BaseResponseVo.ok();
            return ok;
        }
        return null;
    }

    @RequestMapping(value = "admin/log/list")
    public BaseResponseVo logList(int page, int limit, String name, String sort, String order){
        List<CskaoyanMallLog> logs = systemManageService.logList(page, limit, name, sort, order);
        long total = systemManageService.countAllLog();
        if (logs != null){
            BaseResponseVo ok = ok(logs, total);
            return ok;
        }
        return null;
    }

    @RequestMapping(value = "admin/role/list")
    public BaseResponseVo roleList(int page, int limit, String name, String sort, String order){
        List<CskaoyanMallRole> roles = systemManageService.roleList(page, limit, name, sort, order);
        long total = systemManageService.countAllRole();
        if (roles != null){
            BaseResponseVo ok = ok(roles, total);
            return ok;
        }
        return null;
    }

    @GetMapping(value = "admin/role/permissions")
    public BaseResponseVo permissions(int roleId){
        List<SystemPermissionVo> systemPermissions = systemManageService.systempermissionsList();
        List<String> assignedPermissions = systemManageService.queryPermissionsByRoleId(roleId);
        PermissionVo permissionVo = new PermissionVo(assignedPermissions, systemPermissions);
        if (permissionVo != null) {
            BaseResponseVo ok = BaseResponseVo.ok(permissionVo);
            return ok;
        }
        return null;
    }

    @PostMapping(value = "admin/role/permissions")
    public BaseResponseVo permissions(@RequestBody Permission permission){
        systemManageService.updatePermissions(permission.getRoleId(), permission.getPermissions());
        return BaseResponseVo.ok();
    }

    private BaseResponseVo ok(List<?> data, long total){
        ItemsVo itemsVo = new ItemsVo();
        itemsVo.setTotal(total);
        itemsVo.setItems(data);
        BaseResponseVo ok = BaseResponseVo.ok(itemsVo);
        return ok;
    }
}
