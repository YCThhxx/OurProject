package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;

import java.util.List;

public class ItemsVo<T> {
    long total;
    List<T> items;

    @Override
    public String toString() {
        return "ItemsVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
