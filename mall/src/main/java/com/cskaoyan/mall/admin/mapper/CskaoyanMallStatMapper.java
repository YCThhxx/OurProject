package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.vo.statvo.*;

import java.util.List;

public interface CskaoyanMallStatMapper {

    public List<UserStatVo> getUserStat();

    public List<OrderStatVo> getOrderStat();

    public List<GoodsStatVo> getGoodsStat();

}
