package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.admin.util.PagingUtil;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/coupon")
public class CouponController {
    @Autowired
    CouponService couponService;
    @RequestMapping("list")
    public BaseResponseVo listOfCoupon(String page, String limit, String name, String type, String status, String sort,String order){
        PageBean listOfAd = couponService.listOfCoupon(PagingUtil.returnPage(page), PagingUtil.returnPageSize(limit),name,type,status,sort,order);
        BaseResponseVo ok = BaseResponseVo.ok(listOfAd);
        return ok;
    }
    @RequestMapping("read")
    public BaseResponseVo read(int id){
      CskaoyanMallCoupon coupon = couponService.read(id);
        BaseResponseVo ok = BaseResponseVo.ok(coupon);
        return ok;
    }
    @RequestMapping("delete")
    public BaseResponseVo delete(@RequestBody CskaoyanMallCoupon coupon){
        couponService.delete(coupon.getId());
        BaseResponseVo ok = BaseResponseVo.ok(null);
        return  ok;
    }
    @RequestMapping("listuser")
    public BaseResponseVo listuser(String page,String limit,String couponId,String sort,String order,String userId,String status){
        PageBean listOfAd = couponService.listuser(PagingUtil.returnPage(page), PagingUtil.returnPageSize(limit),couponId,sort,order,userId,status);
        BaseResponseVo ok = BaseResponseVo.ok(listOfAd);
        return ok;
    }
    @RequestMapping("update")
    public BaseResponseVo update(@RequestBody CskaoyanMallCoupon cskaoyanMallCoupon){
        couponService.update(cskaoyanMallCoupon);
        BaseResponseVo ok = BaseResponseVo.ok(cskaoyanMallCoupon);
        return  ok;
    }
    @RequestMapping("create")
    public  BaseResponseVo create(@RequestBody CskaoyanMallCoupon cskaoyanMallCoupon){
        couponService.create(cskaoyanMallCoupon);
        BaseResponseVo ok = BaseResponseVo.ok(cskaoyanMallCoupon);
        return  ok;
    }
}
