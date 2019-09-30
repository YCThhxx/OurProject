package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;

public interface CskaoyanMallCouponMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCoupon record);

    int updateByPrimaryKey(CskaoyanMallCoupon record);
}