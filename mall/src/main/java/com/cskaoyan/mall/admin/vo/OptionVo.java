package com.cskaoyan.mall.admin.vo;

public class OptionVo {
    int value;
    String label;

    @Override
    public String toString() {
        return "OptionVo{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }

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
}
