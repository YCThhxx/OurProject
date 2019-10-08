package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsProduct;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallAddressMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCartMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsProductMapper;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.util.CartUtil;
import com.cskaoyan.mall.wx.vo.*;
import com.cskaoyan.mall.wx.vo.homeIndex.CartCheckRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.ResponseCache;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
        @Autowired
        CskaoyanMallCartMapper  cartMapper;
        @Autowired
        CskaoyanMallGoodsMapper goodsmapper;
        @Autowired
    CskaoyanMallGoodsProductMapper productMapper;
        @Autowired
    CskaoyanMallAddressMapper cskaoyanMallAddressMapper;
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
        return CartUtil.queryCartListByName(username,cartMapper);
    }

    @Override
    public void delete(CartDeleteRequest cartDeleteRequest) {
        String[] productIds = cartDeleteRequest.getProductIds();
        for (String productId : productIds) {
            int i = Integer.parseInt(productId);
            cartMapper.deleteByPrimaryKey(i);
        }
    }

    @Override
    public void update(int productId, int number, String username) {
        int userId = cartMapper.queryUserIdByUsername(username);
        cartMapper.update(productId,number,userId);
    }

    @Override
    public CartResp check(String username, CartCheckRequest cartCheckRequest) {
        int userId = cartMapper.queryUserIdByUsername(username);
        int[] productIds = cartCheckRequest.getProductIds();
        int isChecked = cartCheckRequest.getIsChecked();
        for (int productId : productIds) {
            if (isChecked == 1){
                cartMapper.updateCheck(1,userId,productId);
            }else {
                cartMapper.updateCheck(0,userId,productId);
            }
        }
        return CartUtil.queryCartListByName(username,cartMapper);
    }

    @Override
    public int goodscount(String username) {
        int userId = cartMapper.queryUserIdByUsername(username);
        return  cartMapper.queryGoodsSum(userId);
    }

    @Override
    public int fastAdd(String username, AddRequest addRequest) throws ParseException {
        int goodsId = addRequest.getGoodsId();
        int number = addRequest.getNumber();
        int productId = addRequest.getProductId();
        int userId = cartMapper.queryUserIdByUsername(username);
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
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        Date parse = sdf.parse(format);
        cskaoyanMallCart.setAddTime(parse);
        cskaoyanMallCart.setUpdateTime(parse);
        cartMapper.insert(cskaoyanMallCart);
        int cartId = cartMapper.queryCartIdByDateAndUserId(userId,parse);
        return  cartId ;
    }

//    @Override
//    public CartCheckoutResp checkOut(String username, int cartId, int addressId, int couponId, int grouponRulesId) {
//        CartCheckoutResp cartCheckoutResp = new CartCheckoutResp();
//        CartResp cartResp = CartUtil.queryCartListByName(username, cartMapper);
//        List<CskaoyanMallCart> cartList = cartResp.getCartList();
//        cartCheckoutResp.setCheckedGoodsList(cartList);
//        CskaoyanMallAddress cskaoyanMallAddress = cskaoyanMallAddressMapper.selectByPrimaryKey(addressId);
//        cartCheckoutResp.setCheckedAddress(cskaoyanMallAddress);
//        
//    }


}
