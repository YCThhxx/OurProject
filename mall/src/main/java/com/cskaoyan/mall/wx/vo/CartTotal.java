package com.cskaoyan.mall.wx.vo;

public class CartTotal {
    int goodsCount;
    int checkedGoodsCount;
    double goodsAmount;
    double checkedGoodsAmount;
    public CartTotal(){
        
    }

    public CartTotal(int goodsCount, int checkedGoodsCount, double goodsAmount, double checkedGoodsAmount) {
        this.goodsCount = goodsCount;
        this.checkedGoodsCount = checkedGoodsCount;
        this.goodsAmount = goodsAmount;
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public double getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(double checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    @Override
    public String toString() {
        return "CartTotal{" +
                "goodsCount=" + goodsCount +
                ", checkedGoodsCount=" + checkedGoodsCount +
                ", goodsAmount=" + goodsAmount +
                ", checkedGoodsAmount=" + checkedGoodsAmount +
                '}';
    }
}
