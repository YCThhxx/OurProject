package com.cskaoyan.mall.admin.vo.permissionvo;

import java.util.List;

public class SystemPermissionVo {
    int pid;
    int parent_id;
    String id;
    String api;
    String label;
    List<SystemPermissionVo> children;

    @Override
    public String toString() {
        return "SystemPermissionVo{" +
                "pid=" + pid +
                ", parent_id=" + parent_id +
                ", id='" + id + '\'' +
                ", api='" + api + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<SystemPermissionVo> getChildren() {
        return children;
    }

    public void setChildren(List<SystemPermissionVo> children) {
        this.children = children;
    }
}
