package com.cskaoyan.mall.wx.vo.orderVo;

import java.util.List;

public class OrderDetailVo {
    OrderInfoVo orderInfo;
    List<OrderGoodsVo> orderGoods;

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "orderInfo=" + orderInfo +
                ", orderGoods=" + orderGoods +
                '}';
    }

    public OrderInfoVo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoVo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderGoodsVo> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoodsVo> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
