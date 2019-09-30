package com.cskaoyan.mall.marketmanager.dto;




import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegionInfo {

    private int id;

    private String name;

    private int type;//省市区

    int code;//邮编

    List<RegionInfo> children =  new ArrayList<RegionInfo>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<RegionInfo> getChildren() {
        return children;
    }

    public void setChildren(List<RegionInfo> children) {
        this.children = children;
    }

    public RegionInfo() {
    }

    public RegionInfo(int id, String name, int type, int code, List<RegionInfo> children) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.code = code;
        this.children = children;
    }
}
