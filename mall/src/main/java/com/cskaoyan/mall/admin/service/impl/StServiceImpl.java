package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.mapper.CskaoyanMallStatMapper;
import com.cskaoyan.mall.admin.service.StService;
import com.cskaoyan.mall.admin.vo.statvo.GoodsStatVo;
import com.cskaoyan.mall.admin.vo.statvo.OrderStatVo;
import com.cskaoyan.mall.admin.vo.statvo.StatVo;
import com.cskaoyan.mall.admin.vo.statvo.UserStatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StServiceImpl implements StService {

    @Autowired
    CskaoyanMallStatMapper mapper;

    @Override
    public StatVo getUserStat() {
        List<String> columns = new ArrayList<>();
        columns.add("day");
        columns.add("users");
        List<UserStatVo> userStatVos = mapper.getUserStat();
        StatVo statVo = new StatVo();
        statVo.setColumns(columns);
        statVo.setRows(userStatVos);
        return statVo;
    }

    @Override
    public StatVo getOrderStat() {
        List<String> columns = new ArrayList<>();
        columns.add("day");
        columns.add("orders");
        columns.add("customers");
        columns.add("amount");
        columns.add("pcr");
        List<OrderStatVo> orderStatVos = mapper.getOrderStat();
        StatVo statVo = new StatVo();
        statVo.setColumns(columns);
        statVo.setRows(orderStatVos);
        return statVo;
    }

    @Override
    public StatVo getGoodsStat() {
        List<String> columns = new ArrayList<>();
        columns.add("day");
        columns.add("orders");
        columns.add("products");
        columns.add("amount");
        List<GoodsStatVo> goodsStatVos = mapper.getGoodsStat();
        StatVo statVo = new StatVo();
        statVo.setColumns(columns);
        statVo.setRows(goodsStatVos);
        return statVo;
    }
}
