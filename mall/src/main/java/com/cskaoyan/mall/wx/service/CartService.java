package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.util.CheckData;
import com.cskaoyan.mall.wx.vo.*;
import com.cskaoyan.mall.wx.vo.homeIndex.CartCheckRequest;

public interface CartService {
    void add(AddRequest addRequest, String principal);

    CartResp queryCartByUsername(String username);

    void delete(CartDeleteRequest cartDeleteRequest);

    void update(int productId, int number, String username);

    CartResp check(String username, CartCheckRequest cartCheckRequest);

    int goodscount(String username);

    int fastAdd(String username, AddRequest addRequest);

    CheckData checkout(int cartId, int addressId, int couponId, int grouponRules);

}
