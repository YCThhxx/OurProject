package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.statvo.StatVo;

public interface StService {

    StatVo getUserStat();

    StatVo getOrderStat();

    StatVo getGoodsStat();
}
