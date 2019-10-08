package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.WxOrderService;
import com.cskaoyan.mall.wx.util.HandleOption;
import com.cskaoyan.mall.wx.vo.orderVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WxOrderServiceImpl implements WxOrderService {

    @Autowired
    CskaoyanMallOrderMapper orderMapper;
    @Autowired
    CskaoyanMallAddressMapper addressMapper;
    @Autowired
    CskaoyanMallRegionMapper regionMapper;
    @Autowired
    CskaoyanMallOrderGoodsMapper orderGoodsMapper;
    @Autowired
    CskaoyanMallGoodsMapper goodsMapper;
    @Autowired
    CskaoyanMallGoodsProductMapper goodsProductMapper;
    @Autowired
    CskaoyanMallCartMapper cartMapper;
    @Autowired
    CskaoyanMallCouponMapper couponMapper;
    @Autowired
    CskaoyanMallGrouponMapper grouponMapper;
    @Autowired
    CskaoyanMallGrouponRulesMapper grouponRulesMapper;
    @Autowired
    CskaoyanMallSystemMapper systemMapper;

    @Override
    public List<OrderListVo> getOrderListByUserId(int userId, int showType, int page, int size) {
        //PageHelper.startPage(page, size);

        int status = 1;
        switch(showType){
            case 1:
                status = 101;
                break;
            case 2:
                status = 201;
                break;
            case 3:
                status = 301;
                break;
            case 4:
                status = 401;
                break;
            default:
                break;
        }
        List<OrderListVo> orders = orderMapper.queryOrderByUserId(userId, status);
        HandleOption handleOption = new HandleOption(status);
        for (OrderListVo order : orders) {
            switch (order.getOrderStatus()) {
                case 101:
                    order.setOrderStatusText("未付款");
                    break;
                case 102:
                    order.setOrderStatusText("用户取消");
                    break;
                case 103:
                    order.setOrderStatusText("系统取消");
                    break;
                case 201:
                    order.setOrderStatusText("已付款");
                    break;
                case 202:
                    order.setOrderStatusText("申请退款");
                    break;
                case 203:
                    order.setOrderStatusText("已退款");
                    break;
                case 301:
                    order.setOrderStatusText("已发货");
                    break;
                case 401:
                    order.setOrderStatusText("用户收货");
                    break;
                case 402:
                    order.setOrderStatusText("系统收货");
                    break;
                default:
                    break;
            }
            order.setHandleOption(handleOption);
        }
        return orders;
    }

    @Override
    public int getOrderAmountByUserId(int userId) {
        return orderMapper.queryOrderAmountByUserId(userId);
    }

    @Override
    public OrderDetailVo getOrderDetailByOrderId(int orderId) {
        OrderDetailVo orderDetail = new OrderDetailVo();

        CskaoyanMallOrder order = orderMapper.selectByPrimaryKey(orderId);
        String consignee = order.getConsignee();
        CskaoyanMallAddress address = addressMapper.selectByName(consignee);
        OrderInfoVo orderInfo = new OrderInfoVo();
        orderInfo.setConsignee(address.getName());
        String province = regionMapper.selectAddressByCode(address.getProvinceId());
        String city = regionMapper.selectAddressByCode(address.getCityId());
        String area = regionMapper.selectAddressByCode(address.getAreaId());
        String addressSummary = province+" "+city+" "+area+" "+address.getAddress();
        orderInfo.setAddress(addressSummary);
        orderInfo.setAddTime(order.getAddTime());
        orderInfo.setOrderSn(order.getOrderSn());
        orderInfo.setActualPrice(order.getActualPrice().floatValue());
        orderInfo.setMobile(address.getMobile());
        orderInfo.setOrderStatusText(getOrderStatusT(order));
        orderInfo.setGoodsPrice(order.getGoodsPrice().floatValue());
        orderInfo.setCouponPrice(order.getCouponPrice().floatValue());
        orderInfo.setId(orderId);
        orderInfo.setFreightPrice(order.getFreightPrice().floatValue());
        orderInfo.setHandleOption(new HandleOption(order.getOrderStatus()));
        orderDetail.setOrderInfo(orderInfo);

        List<OrderGoodsVo> orderGoodsVos = new ArrayList<>();
        List<CskaoyanMallOrderGoods> orderGoods = orderGoodsMapper.selectByOrderId(orderId);
        for (CskaoyanMallOrderGoods orderGood : orderGoods) {
            OrderGoodsVo orderGoodsVo = new OrderGoodsVo();
            CskaoyanMallGoods goods = goodsMapper.selectByPrimaryKey(orderGood.getGoodsId());
            CskaoyanMallGoodsProduct goodsProduct = goodsProductMapper.selectByPrimaryKey(orderGood.getProductId());
            orderGoodsVo.setId(orderGood.getId());
            orderGoodsVo.setOrderId(orderGood.getOrderId());
            orderGoodsVo.setGoodsId(orderGood.getGoodsId());
            orderGoodsVo.setGoodsName(goods.getName());
            orderGoodsVo.setGoodsSn(goods.getGoodsSn());
            orderGoodsVo.setProductId(orderGood.getProductId());
            orderGoodsVo.setNumber(orderGood.getNumber());
            orderGoodsVo.setPrice(orderGood.getPrice().floatValue());
            orderGoodsVo.setSpecifications(goodsProduct.getSpecifications());
            orderGoodsVo.setPicUrl(goods.getPicUrl());
            orderGoodsVo.setComment(orderGood.getComment());
            orderGoodsVo.setAddTime(orderGood.getAddTime());
            orderGoodsVo.setUpdateTime(orderGood.getUpdateTime());
            orderGoodsVo.setDeleted(false);
            orderGoodsVos.add(orderGoodsVo);
        }
        orderDetail.setOrderGoods(orderGoodsVos);
        return orderDetail;
    }

    @Override
    public int submit(int userId, SubmitRequest submitRequest) {
        Date add_time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderSn = format.format(add_time);
        List<CskaoyanMallCart> carts = new ArrayList<>();
        if (submitRequest.getCartId()!=0) {
            CskaoyanMallCart cart = cartMapper.selectByPrimaryKey(submitRequest.getCartId());
            carts.add(cart);
        }else {
            carts = cartMapper.selectByUserIdAndChecked(userId);
        }
        CskaoyanMallAddress address = addressMapper.selectByPrimaryKey(submitRequest.getAddressId());
        CskaoyanMallCoupon coupon = couponMapper.selectByPrimaryKey(submitRequest.getCouponId());
        //CskaoyanMallGroupon groupon = grouponMapper.selectByGrouponId(submitRequest.getGrouponLinkId());
        CskaoyanMallGrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(submitRequest.getGrouponRulesId());

        List<CskaoyanMallGoods> goods = new ArrayList<>();
        for (CskaoyanMallCart cart : carts) {
            CskaoyanMallGoods good = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
            goods.add(good);
        }

        CskaoyanMallOrder order = new CskaoyanMallOrder();
        order.setUserId(userId);
        order.setOrderSn(orderSn);
        order.setOrderStatus((short) 101);
        order.setConsignee(address.getName());
        order.setMobile(address.getMobile());
        order.setAddress(address.getAddress());
        order.setMessage(submitRequest.getMessage());
        float sumPrice = 0;
        for (CskaoyanMallCart cart : carts) {
            System.out.println(cart.getPrice() + " " + cart.getNumber());
            sumPrice += cart.getPrice().floatValue()*cart.getNumber();
        }
        order.setGoodsPrice(new BigDecimal((double) sumPrice));
        List<CskaoyanMallSystem> systems = systemMapper.selectAll();
        double min = 0;
        double freight = 0;
        for (CskaoyanMallSystem system : systems) {
            if (system.getKeyName().equals("cskaoyan_mall_express_freight_min")){
                min = Double.parseDouble(system.getKeyValue());
            }
            if (system.getKeyName().equals("cskaoyan_mall_express_freight_value")){
                freight = Double.parseDouble(system.getKeyValue());
            }
        }
        if (sumPrice <= min) {
            order.setFreightPrice(new BigDecimal(freight));
        }else{
            order.setFreightPrice(new BigDecimal(0));
        }

        if (grouponRules!=null){
            order.setGrouponPrice(grouponRules.getDiscount());
        }else {
            order.setGrouponPrice(new BigDecimal(0));
        }

        if (coupon!=null){
            order.setCouponPrice(coupon.getDiscount());
        }else {
            order.setCouponPrice(new BigDecimal(0));
        }
        order.setIntegralPrice(new BigDecimal(0));
        order.setOrderPrice(new BigDecimal(order.getGoodsPrice().doubleValue()
                            +order.getFreightPrice().doubleValue()
                            -order.getCouponPrice().doubleValue()));
        order.setActualPrice(order.getOrderPrice());
        order.setAddTime(add_time);
        order.setUpdateTime(add_time);
        order.setDeleted(false);
        orderMapper.insertSelective(order);
        int orderId = orderMapper.queryMaxOrderIdValue();
        for (CskaoyanMallGoods good : goods) {
            CskaoyanMallOrderGoods orderGoods = new CskaoyanMallOrderGoods();
            orderGoods.setOrderId(orderId);
            orderGoods.setGoodsId(good.getId());
            orderGoods.setGoodsName(good.getName());
            orderGoods.setGoodsSn(good.getGoodsSn());
            for (CskaoyanMallCart cart : carts) {
                if (cart.getGoodsId().intValue() == good.getId().intValue()){
                    orderGoods.setProductId(cart.getProductId());
                    CskaoyanMallGoodsProduct product = goodsProductMapper.selectByPrimaryKey(orderGoods.getProductId());
                    orderGoods.setNumber(cart.getNumber());
                    orderGoods.setPrice(cart.getPrice());
                    orderGoods.setSpecifications(product.getSpecifications());
                    break;
                }
            }
            orderGoods.setPicUrl(good.getPicUrl());
            orderGoods.setComment(0);
            orderGoods.setAddTime(add_time);
            orderGoods.setUpdateTime(add_time);
            orderGoods.setDeleted(false);
            orderGoodsMapper.insert(orderGoods);
        }

        cartMapper.deleteByUserIdAndChecked(userId);

        return orderId;
    }

    @Override
    public void cancelOrder(int id) {
        int i = orderMapper.deleteByPrimaryKey(id);
        int j = orderGoodsMapper.deleteByOrderId(id);
    }

    @Override
    public void confirmOrder(int orderId) {
        orderMapper.updateStatusByOrderId(orderId,301, 401);
    }

    @Override
    public void prepayOrder(int orderId) {
        orderMapper.updateStatusByOrderId(orderId,101, 201);
    }

    private String getOrderStatusT(CskaoyanMallOrder order){
        switch (order.getOrderStatus()) {
            case 101:
                order.setOrderStatusText("未付款");
                break;
            case 102:
                order.setOrderStatusText("用户取消");
                break;
            case 103:
                order.setOrderStatusText("系统取消");
                break;
            case 201:
                order.setOrderStatusText("已付款");
                break;
            case 202:
                order.setOrderStatusText("申请退款");
                break;
            case 203:
                order.setOrderStatusText("已退款");
                break;
            case 301:
                order.setOrderStatusText("已发货");
                break;
            case 401:
                order.setOrderStatusText("用户收货");
                break;
            case 402:
                order.setOrderStatusText("系统收货");
                break;
            default:
                break;
        }
        return order.getOrderStatusText();
    }

}
