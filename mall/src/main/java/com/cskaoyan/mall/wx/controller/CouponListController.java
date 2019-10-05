package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import com.cskaoyan.mall.wx.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coupon")
public class CouponListController {

    @Autowired
    CouponService couponService;

    @GetMapping("/list")
    public BaseRespVo couponList(@RequestParam("page") int page,
                                  @RequestParam("size") int size){
        DataUtil dataUtil =  couponService.getCouponList(page,size);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setData(dataUtil);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
}
