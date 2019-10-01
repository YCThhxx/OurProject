package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallOrder;
import com.cskaoyan.mall.admin.bean.CskaoyanMallOrderGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;

import java.util.List;

public class OrderDetail {
    CskaoyanMallOrder order;

    List<CskaoyanMallOrderGoods> orderGoods;

    CskaoyanMallUser user;

    public OrderDetail(CskaoyanMallOrder order, List<CskaoyanMallOrderGoods> orderGoods, CskaoyanMallUser user) {
        this.order = order;
        this.orderGoods = orderGoods;
        this.user = user;
    }

    public OrderDetail() {
    }

    public CskaoyanMallOrder getOrder() {
        return order;
    }

    public void setOrder(CskaoyanMallOrder order) {
        this.order = order;
    }

    public List<CskaoyanMallOrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<CskaoyanMallOrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public CskaoyanMallUser getUser() {
        return user;
    }

    public void setUser(CskaoyanMallUser user) {
        this.user = user;
    }
}
