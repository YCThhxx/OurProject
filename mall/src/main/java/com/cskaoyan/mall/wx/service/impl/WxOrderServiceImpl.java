package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.WxOrderService;
import com.cskaoyan.mall.wx.util.HandleOption;
import com.cskaoyan.mall.wx.vo.orderVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        int consigneeId = Integer.parseInt(order.getConsignee());
        CskaoyanMallAddress address = addressMapper.selectByPrimaryKey(consigneeId);
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
    public int submit(SubmitRequest submitRequest) {
        int cartId = submitRequest.getCartId();
        CskaoyanMallCart cart = cartMapper.selectByPrimaryKey(cartId);

        return 0;
    }

    @Override
    public void cancelOrder(int id) {
        int i = orderMapper.deleteByPrimaryKey(id);
        int j = orderGoodsMapper.deleteByOrderId(id);
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
