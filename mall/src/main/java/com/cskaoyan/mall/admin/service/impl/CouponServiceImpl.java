package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCouponUser;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCouponMapper;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.wx.util.DataUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CskaoyanMallCouponMapper cskaoyanMallCouponMapper;

    @Override
    public PageBean listOfCoupon(int pages, int pageSize, String name, String type, String status, String sort, String order) {
        String orderBy = sort +" " + order;
        PageHelper.startPage(pages, pageSize, orderBy);
        List<CskaoyanMallCoupon> coupons = cskaoyanMallCouponMapper.selectByPageAndPageSize(name,type,status);
        PageInfo<CskaoyanMallCoupon> couponPageInfo = new PageInfo<>(coupons);
        long total = couponPageInfo.getTotal();
        PageBean<List> pageListBean = new PageBean<>();
        pageListBean.setItems(coupons);
        pageListBean.setTotal(total);
        return pageListBean;
    }

    @Override
    public CskaoyanMallCoupon read(int id) {
        return cskaoyanMallCouponMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Integer id) {
        cskaoyanMallCouponMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean listuser(int returnPage, int returnPageSize, String couponId, String sort, String order, String userId, String status) {
        String orderBy = sort +" " + order;
        PageHelper.startPage(returnPage, returnPageSize, orderBy);
        List<CskaoyanMallCouponUser> users = cskaoyanMallCouponMapper.listuser(userId,status,couponId);
        PageInfo<CskaoyanMallCouponUser> usersPageInfo = new PageInfo<>(users);
        long total = usersPageInfo.getTotal();
        PageBean<List> pageListBean = new PageBean<>();
        pageListBean.setItems(users);
        pageListBean.setTotal(total);
        return pageListBean;
    }

    @Override
    public void update(CskaoyanMallCoupon cskaoyanMallCoupon) {
        cskaoyanMallCoupon.setUpdateTime(new Date());
        cskaoyanMallCouponMapper.updateByPrimaryKeySelective(cskaoyanMallCoupon);
    }

    @Override
    public void create(CskaoyanMallCoupon cskaoyanMallCoupon) {
        cskaoyanMallCoupon.setAddTime(new Date());
        cskaoyanMallCoupon.setUpdateTime(new Date());
        cskaoyanMallCouponMapper.insert(cskaoyanMallCoupon);
    }

    @Override
    public DataUtil getCouponList(int page, int size) {
        PageHelper.startPage(page, size);
       List<CskaoyanMallCoupon> coupons = cskaoyanMallCouponMapper.queryCoupons();
        PageInfo<CskaoyanMallCoupon> pageInfo = new PageInfo<>(coupons);
        long total = pageInfo.getTotal();
        DataUtil<List> dataUtil = new DataUtil<>();
        dataUtil.setConut((int)total);
        dataUtil.setData(coupons);
        return dataUtil;
    }


}
