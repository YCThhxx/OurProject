package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class CategoryData {

    String desc;

    String iconUrl;

    int id;

    String keywords;

    String level;

    String name;

    String picUrl;

    List<CategoryChildren> children;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public List<CategoryChildren> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryChildren> children) {
        this.children = children;
    }

    public CategoryData() {
    }
}
