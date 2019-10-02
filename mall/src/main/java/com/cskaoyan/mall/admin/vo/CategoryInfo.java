package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class CategoryInfo {
    int value;
    String label;
    List<CatChildren> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CatChildren> getChildren() {
        return children;
    }

    public void setChildren(List<CatChildren> children) {
        this.children = children;
    }
}
