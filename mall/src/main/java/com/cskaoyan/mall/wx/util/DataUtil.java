package com.cskaoyan.mall.wx.util;

public class DataUtil<T> {
    int conut;

    T data;

    public int getConut() {
        return conut;
    }

    public void setConut(int conut) {
        this.conut = conut;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DataUtil() {
    }

}
