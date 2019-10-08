package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.vo.orderVo.OrderDetailVo;
import com.cskaoyan.mall.wx.vo.orderVo.OrderListVo;
import com.cskaoyan.mall.wx.vo.orderVo.SubmitRequest;

import java.util.List;

public interface WxOrderService {
    List<OrderListVo> getOrderListByUserId(int userId, int showType, int page, int size);

    int getOrderAmountByUserId(int userId);

    OrderDetailVo getOrderDetailByOrderId(int orderId);

    int submit(int userId, SubmitRequest submitRequest);

    void cancelOrder(int id);

    void confirmOrder(int orderId);

    void prepayOrder(int orderId);
}
