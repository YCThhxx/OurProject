package com.cskaoyan.mall.wx.util;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCartMapper;
import com.cskaoyan.mall.wx.vo.CartResp;
import com.cskaoyan.mall.wx.vo.CartTotal;

import java.util.List;

public class CartUtil {
    
    private CartUtil(){
        
    }
    public  static CartResp queryCartListByName(String name,CskaoyanMallCartMapper cartMapper){
        int userId = cartMapper.queryUserIdByUsername(name);
        List<CskaoyanMallCart> cartlist = cartMapper.quertCartByUserId(userId);
        int  goodsCount = 0;
        double goodsAmount = 0;
        double checkedGoodsAmount = 0;
        int checkGoodsCount = 0;
        for (CskaoyanMallCart cskaoyanMallCart : cartlist) {
            goodsCount  = cskaoyanMallCart.getNumber() + goodsCount;
            goodsAmount = (cskaoyanMallCart.getNumber().intValue()) * (cskaoyanMallCart.getPrice().doubleValue()) + goodsAmount;
            if (cskaoyanMallCart.getChecked()){
                checkGoodsCount  = cskaoyanMallCart.getNumber() + checkGoodsCount;
                checkedGoodsAmount = (cskaoyanMallCart.getNumber().intValue()) * (cskaoyanMallCart.getPrice().doubleValue()) + checkedGoodsAmount;
            }
        }
        CartTotal cartTotal = new CartTotal();
        cartTotal.setGoodsAmount(goodsAmount);
        cartTotal.setGoodsCount(goodsCount);
        cartTotal.setCheckedGoodsCount(checkGoodsCount);
        cartTotal.setCheckedGoodsAmount(checkedGoodsAmount);
        CartResp cartResp = new CartResp();
        cartResp.setCartList(cartlist);
        cartResp.setCartTotal(cartTotal);
        return  cartResp;
    }
}
