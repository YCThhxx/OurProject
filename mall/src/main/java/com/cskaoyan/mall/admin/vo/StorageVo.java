package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;

import java.util.List;

public class StorageVo {
    int total;
    List<CskaoyanMallStorage> items;

    @Override
    public String toString() {
        return "StorageVo{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CskaoyanMallStorage> getItems() {
        return items;
    }

    public void setItems(List<CskaoyanMallStorage> items) {
        this.items = items;
    }
}
