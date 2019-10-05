package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.MallApplication;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsExample;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsProduct;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCartMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsProductMapper;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.vo.AddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartServiceImpl implements CartService {
        @Autowired
        CskaoyanMallCartMapper  cartMapper;
        @Autowired
        CskaoyanMallGoodsMapper goodsmapper;
        @Autowired
    CskaoyanMallGoodsProductMapper productMapper;
    @Override
    public void add(AddRequest addRequest, String principal) {
        int goodsId = addRequest.getGoodsId();
        int number = addRequest.getNumber();
        int productId = addRequest.getProductId();
        int userId = cartMapper.queryUserIdByUsername(principal);
        CskaoyanMallGoods goods = goodsmapper.selectByPrimaryKey(goodsId);
        CskaoyanMallGoodsProduct product = productMapper.selectByPrimaryKey(productId);
        CskaoyanMallCart cskaoyanMallCart = new CskaoyanMallCart();
        cskaoyanMallCart.setUserId(userId);
        cskaoyanMallCart.setGoodsId(goodsId);
        cskaoyanMallCart.setGoodsSn(goods.getGoodsSn());
        cskaoyanMallCart.setGoodsName(goods.getName());
        cskaoyanMallCart.setProductId(productId);
        cskaoyanMallCart.setPrice(product.getPrice());
        cskaoyanMallCart.setNumber((short) number);
        cskaoyanMallCart.setSpecifications(product.getSpecifications());
        cskaoyanMallCart.setPicUrl(goods.getPicUrl());
        cskaoyanMallCart.setAddTime(new Date());
        cskaoyanMallCart.setUpdateTime(new Date());
        cartMapper.insert(cskaoyanMallCart);
    }
}
