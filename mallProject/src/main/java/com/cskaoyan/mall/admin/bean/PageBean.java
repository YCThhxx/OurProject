package com.cskaoyan.mall.admin.bean;

/**
 * author : Nianjie Jing
 * creat time : 2019/9/30
 * e-mail : clemeting@qq.com
 */
public class PageBean<T> {
    T items;
    Long total;

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
