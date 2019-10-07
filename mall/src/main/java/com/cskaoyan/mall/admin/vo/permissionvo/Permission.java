package com.cskaoyan.mall.admin.vo.permissionvo;

public class Permission {
    int roleId;
    String[] permissions;

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
