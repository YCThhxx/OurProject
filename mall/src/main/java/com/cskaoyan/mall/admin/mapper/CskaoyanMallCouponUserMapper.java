package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface CskaoyanMallCouponUserMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCouponUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCouponUser record);

    int updateByPrimaryKey(CskaoyanMallCouponUser record);

    int receiveCoupon(Date startTime, Date endTime, Date addTime, Date updateTime,
                      @Param("couponId") int couponId,
                      @Param("userId") int userId);
}