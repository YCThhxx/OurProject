package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUser;

public interface CskaoyanMallCouponUserMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCouponUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCouponUser record);

    int updateByPrimaryKey(CskaoyanMallCouponUser record);
}