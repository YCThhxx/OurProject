package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.util.CartUtil;
import com.cskaoyan.mall.wx.util.CheckData;
import com.cskaoyan.mall.wx.vo.*;
import com.cskaoyan.mall.wx.vo.homeIndex.CartCheckRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        CskaoyanMallAddressMapper addressMapper;

        @Autowired
        CskaoyanMallCouponUserMapper couponUserMapper;

        @Autowired
        CskaoyanMallCouponMapper couponMapper;

        @Autowired
        CskaoyanMallGrouponRulesMapper grouponRulesMapper;

        @Autowired
        CskaoyanMallRegionMapper regionMapper;
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

    @Override
    public CheckData checkout(int cartId, int addressId, int couponId, int grouponRulesId) {
        CskaoyanMallCart cart = cartMapper.selectByPrimaryKey(cartId);
        CheckData checkData = new CheckData();
        Integer userId = cart.getUserId();
        BigDecimal discount = new BigDecimal(0);
        BigDecimal discount1 = new BigDecimal(0);
        CskaoyanMallAddress address = addressMapper.selectByPrimaryKey(userId);
        Integer provinceId = address.getProvinceId();
        String name = regionMapper.selectNameById(provinceId);
        Integer cityId = address.getCityId();
        String name1 = regionMapper.selectNameById(cityId);
        Integer areaId = address.getAreaId();
        String name2 = regionMapper.selectNameById(areaId);
        String address1 = address.getAddress();
        String checkedAddress = name + name1 +name2 + address1;
        int length = couponUserMapper.selectLength(couponId,userId);
        //商品总价
        BigDecimal price = cart.getPrice();
        CskaoyanMallCoupon coupon = couponMapper.selectByPrimaryKey(couponId);
        CskaoyanMallGrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);
        if(coupon != null){
            //优惠券的价格
             discount = coupon.getDiscount();
        }
        if (grouponRules != null){
            discount1 = grouponRules.getDiscount();
        }
        //团购优惠价格
        //快递费用
        BigDecimal freightPrice = new BigDecimal(8);
       BigDecimal orderTotalPtice = price.add(freightPrice);
       BigDecimal actualPrice = orderTotalPtice.subtract(discount);
       checkData.setActualPrice(actualPrice);
       checkData.setAvailableCouponLength(length);
       checkData.setGoodsTotalPrice(price);
       checkData.setFreightPrice(freightPrice);
       checkData.setCouponPrice(discount);
       checkData.setCheckedAddress(checkedAddress);
       checkData.setAddressId(addressId);
       checkData.setCartId(cartId);
       checkData.setGrouponRulesId(grouponRulesId);
       return checkData;
    }


}
