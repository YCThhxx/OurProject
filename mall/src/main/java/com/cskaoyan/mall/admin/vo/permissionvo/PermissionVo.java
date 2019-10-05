package com.cskaoyan.mall.admin.vo.permissionvo;

import java.util.Arrays;
import java.util.List;

public class PermissionVo {
    private String[] assignedPermissions;
    private List<SystemPermissionVo> systemPermissions;

    public PermissionVo(List<String> assignedPermissions, List<SystemPermissionVo> systemPermissions) {
        int size = assignedPermissions.size();
        String[] temp = new String[size];
        int i = 0;
        for (String assignedPermission : assignedPermissions) {
            temp[i++] = assignedPermission;
        }
        this.assignedPermissions = temp;
        this.systemPermissions = systemPermissions;
    }

    @Override
    public String toString() {
        return "PermissionVo{" +
                "assignedPermissions=" + Arrays.toString(assignedPermissions) +
                ", systemPermissions=" + systemPermissions +
                '}';
    }

    public String[] getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(String[] assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List<SystemPermissionVo> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<SystemPermissionVo> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
