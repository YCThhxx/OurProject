package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public class CartResp {
    List<CskaoyanMallCart>  cartList;
    CartTotal cartTotal;
    public  CartResp(){
        
    }

    public CartResp(List<CskaoyanMallCart> cartList, CartTotal cartTotal) {
        this.cartList = cartList;
        this.cartTotal = cartTotal;
    }

    public List<CskaoyanMallCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<CskaoyanMallCart> cartList) {
        this.cartList = cartList;
    }

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }

    @Override
    public String toString() {
        return "CartResp{" +
                "cartList=" + cartList +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
