package com.cskaoyan.mall.admin.bean;

/**
 * @author Tyj
 * @date 2019/10/5 19:50
 */
public class PageBean3<T> {
    T data;
    int count;
    int currentPage;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
