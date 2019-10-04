package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CskaoyanMallCouponMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCoupon record);

    int updateByPrimaryKey(CskaoyanMallCoupon record);

    List<CskaoyanMallCoupon> selectByPageAndPageSize(@Param("name") String name,@Param("type") String type, @Param("status") String status);

    List<CskaoyanMallCouponUser> listuser(@Param("userId") String userId, @Param("status") String status,@Param("couponId") String couponId);

    void insert(@Param("c") CskaoyanMallCoupon cskaoyanMallCoupon);
    
}