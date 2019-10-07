package com.cskaoyan.mall.wx.vo.homeIndex;

public class CartCheckRequest {
    private int isChecked;
    private  int[] productIds;
    public  CartCheckRequest(){
        
    }

    public CartCheckRequest(int isChecked, int[] productIds) {
        this.isChecked = isChecked;
        this.productIds = productIds;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int[] getProductIds() {
        return productIds;
    }

    public void setProductIds(int[] productIds) {
        this.productIds = productIds;
    }
}
