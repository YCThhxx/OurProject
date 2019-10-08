package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.vo.OrderDetail;

public interface OrderService {

    PageBean showOrderByPage(int page, int limit, String sort, String order, Integer orderStatusArray, String orderSn, Integer userId);

    OrderDetail getOrderDetail(int id);

    boolean insertShip(int orderId, String shipChannel, String shipSn);
}
