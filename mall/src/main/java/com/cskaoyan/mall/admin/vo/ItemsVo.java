package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;

import java.util.List;

public class ItemsVo {
    long total;
    List<?> items;

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

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }
}
