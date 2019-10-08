package com.cskaoyan.mall.wx.vo;

public class AddRequest {
    int goodsId;
    int number;
    int productId;
    public  AddRequest(){
        
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public AddRequest(int goodsId, int number, int productId) {
        this.goodsId = goodsId;
        this.number = number;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "AddRequest{" +
                "goodsId=" + goodsId +
                ", number=" + number +
                ", productId=" + productId +
                '}';
    }
}
