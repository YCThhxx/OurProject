package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.wx.util.DataUtil;

import java.util.List;

public interface CouponService {
    PageBean listOfCoupon(int pages, int pageSize, String name, String type, String status, String sort, String order);

    CskaoyanMallCoupon read(int id);

    void delete(Integer id);

    PageBean listuser(int returnPage, int returnPageSize, String couponId, String sort, String order, String userId, String status);

    void update(CskaoyanMallCoupon cskaoyanMallCoupon);


    void create(CskaoyanMallCoupon cskaoyanMallCoupon);

    DataUtil getCouponList(int page, int size);

    DataUtil getMyCouponsByStatus(int page, int size, int status, Integer userId);

    boolean receiveCoupon(int couponId, Integer userId);

    List<CskaoyanMallCoupon> selectCouponList(int cartId, int grouponRulesId,int userId);

    boolean exchangeCoupon(String code,int userId);
}
