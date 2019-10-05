package com.cskaoyan.mall.admin.bean;

public class PageBean2<T> {
    T collectList;
    Long totalPages;

    public T getCollectList() {
        return collectList;
    }

    public void setCollectList(T collectList) {
        this.collectList = collectList;
    }



    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
