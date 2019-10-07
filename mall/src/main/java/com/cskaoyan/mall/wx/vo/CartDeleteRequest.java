package com.cskaoyan.mall.wx.vo;

public class CartDeleteRequest {
    String[]  productIds;
    
    public  CartDeleteRequest(){
        
    }
    public CartDeleteRequest(String[] productIds) {
        this.productIds = productIds;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }
}
