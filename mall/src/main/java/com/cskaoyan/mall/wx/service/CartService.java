package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.vo.AddRequest;

public interface CartService {
    void add(AddRequest addRequest, String principal);
}
