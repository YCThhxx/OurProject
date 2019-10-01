package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallCouponMapper {
    long countByExample(CskaoyanMallCouponExample example);

    int deleteByExample(CskaoyanMallCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallCoupon record);

    int insertSelective(CskaoyanMallCoupon record);

    List<CskaoyanMallCoupon> selectByExample(CskaoyanMallCouponExample example);

    CskaoyanMallCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallCoupon record, @Param("example") CskaoyanMallCouponExample example);

    int updateByExample(@Param("record") CskaoyanMallCoupon record, @Param("example") CskaoyanMallCouponExample example);

    int updateByPrimaryKeySelective(CskaoyanMallCoupon record);

    int updateByPrimaryKey(CskaoyanMallCoupon record);
}