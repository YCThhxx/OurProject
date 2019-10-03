package com.cskaoyan.mall.admin.vo;

public class DashboardData {
    int goodsTotal;

    int orderTotal;

    int productTotal;

    int userTotal;

    public int getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(int goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(int productTotal) {
        this.productTotal = productTotal;
    }

    public int getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public DashboardData() {
    }

    public DashboardData(int goodsTotal, int orderTotal, int productTotal, int userTotal) {
        this.goodsTotal = goodsTotal;
        this.orderTotal = orderTotal;
        this.productTotal = productTotal;
        this.userTotal = userTotal;
    }
}
