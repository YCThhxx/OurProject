package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallOrder;
import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallOrderGoodsMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallOrderMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.vo.OrderDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    CskaoyanMallOrderMapper cskaoyanMallOrderMapper;

    @Autowired
    CskaoyanMallOrderGoodsMapper cskaoyanMallOrderGoodsMapper;

    @Autowired
    CskaoyanMallUserMapper cskaoyanMallUserMapper;

    @Override
    public PageBean showOrderByPage(int page, int limit, String sort, String order, Integer orderStatusArray, String orderSn, Integer userId) {
        String orderBy = sort +" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List keyList =  cskaoyanMallOrderMapper.showOrderByPage(orderSn,orderStatusArray,userId);
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(keyList);
        PageInfo<CskaoyanMallOrder> pageInfo = new PageInfo<>(keyList);
        long total = pageInfo.getTotal();
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public OrderDetail getOrderDetail(int id) {
        CskaoyanMallOrder order = cskaoyanMallOrderMapper.selectByPrimaryKey(id);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
//        List<CskaoyanMallOrderGoods> orderGoods = cskaoyanMallOrderGoodsMapper.selectByOrderId(id);
//        orderDetail.setOrderGoods(orderGoods);
        Integer userId = order.getUserId();
        CskaoyanMallUser user = cskaoyanMallUserMapper.selectByPrimaryKey(userId);
        orderDetail.setUser(user);
        return orderDetail;
    }

    @Override
    public boolean insertShip(int orderId, String shipChannel, String shipSn) {
//        int i =  cskaoyanMallOrderMapper.insertShin(orderId,shipChannel,shipSn);
        return true;
    }


}
