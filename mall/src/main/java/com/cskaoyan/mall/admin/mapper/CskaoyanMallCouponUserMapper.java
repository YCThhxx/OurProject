package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUser;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallCouponUserMapper {
    long countByExample(CskaoyanMallCouponUserExample example);

    int deleteByExample(CskaoyanMallCouponUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallCouponUser record);

    int insertSelective(CskaoyanMallCouponUser record);

    List<CskaoyanMallCouponUser> selectByExample(CskaoyanMallCouponUserExample example);

    CskaoyanMallCouponUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallCouponUser record, @Param("example") CskaoyanMallCouponUserExample example);

    int updateByExample(@Param("record") CskaoyanMallCouponUser record, @Param("example") CskaoyanMallCouponUserExample example);

    int updateByPrimaryKeySelective(CskaoyanMallCouponUser record);

    int updateByPrimaryKey(CskaoyanMallCouponUser record);
}