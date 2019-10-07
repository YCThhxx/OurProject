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
import com.cskaoyan.mall.wx.vo.CartResp;
import com.cskaoyan.mall.wx.vo.CartTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.validation.constraints.Null;
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

    @Override
    public CartResp queryCartByUsername(String username) {
        int userId = cartMapper.queryUserIdByUsername(username);
        List<CskaoyanMallCart> cartlist = cartMapper.quertCartByUserId(userId);
        int  goodsCount = 0;
        double goodsAmount = 0;
        for (CskaoyanMallCart cskaoyanMallCart : cartlist) {
            goodsCount  = cskaoyanMallCart.getNumber() + goodsCount;
            goodsAmount = (cskaoyanMallCart.getNumber().intValue()) * (cskaoyanMallCart.getPrice().doubleValue()) + goodsAmount;
        }
        CartTotal cartTotal = new CartTotal();
        cartTotal.setGoodsAmount(goodsAmount);
        cartTotal.setGoodsCount(goodsCount);
        cartTotal.setCheckedGoodsCount(goodsCount);
        cartTotal.setCheckedGoodsAmount(goodsAmount);
        CartResp cartResp = new CartResp();
        cartResp.setCartList(cartlist);
        cartResp.setCartTotal(cartTotal);
        return  cartResp;
    }
}
