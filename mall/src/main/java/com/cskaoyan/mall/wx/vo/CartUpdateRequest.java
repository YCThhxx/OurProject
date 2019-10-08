package com.cskaoyan.mall.wx.vo;

public class CartUpdateRequest {
    private int goodsId;
    private int id;
    private int number;
    private int  productId;

    public CartUpdateRequest() {
    }

    public CartUpdateRequest(int goodsId, int id, int number, int productId) {
        this.goodsId = goodsId;
        this.id = id;
        this.number = number;
        this.productId = productId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
