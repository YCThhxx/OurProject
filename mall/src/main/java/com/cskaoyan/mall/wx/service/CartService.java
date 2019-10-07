package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.vo.AddRequest;
import com.cskaoyan.mall.wx.vo.CartResp;

public interface CartService {
    void add(AddRequest addRequest, String principal);

    CartResp queryCartByUsername(String username);
}
