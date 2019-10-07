package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CskaoyanMallCouponMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallCoupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallCoupon record);

    int updateByPrimaryKey(CskaoyanMallCoupon record);

    List<CskaoyanMallCoupon> selectByPageAndPageSize(@Param("name") String name,@Param("type") String type, @Param("status") String status);

    List<CskaoyanMallCouponUser> listuser(@Param("userId") String userId, @Param("status") String status, @Param("couponId") String couponId);

    void insert(@Param("c") CskaoyanMallCoupon cskaoyanMallCoupon);

    @Select("select id,name,`desc`,tag,discount,min,days from cskaoyan_mall_coupon")
    List<CskaoyanMallCoupon> selectCouponList();

}
