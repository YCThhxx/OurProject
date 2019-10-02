package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class RegionData {
    private Integer id;

    private String name;

    private Byte type;

    private Integer code;

    List<RegionData> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<RegionData> getChildren() {
        return children;
    }

    public void setChildren(List<RegionData> children) {
        this.children = children;
    }

    public RegionData() {
    }
}
