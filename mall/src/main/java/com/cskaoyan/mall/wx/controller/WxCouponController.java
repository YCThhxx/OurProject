package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCoupon;
import com.cskaoyan.mall.admin.service.CouponService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import com.cskaoyan.mall.wx.util.DataUtil;
import com.cskaoyan.mall.wx.util.UserTokenManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/coupon")
public class WxCouponController {

    @Autowired
    CouponService couponService;

    @Autowired
    WxUserService wxUserService;

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
    @GetMapping("/mylist")
    public BaseRespVo couponList(HttpServletRequest request, @RequestParam("page") int page,
                                 @RequestParam("size") int size,
                                 @RequestParam("status") int status){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        DataUtil dataUtil =  couponService.getMyCouponsByStatus(page,size,status,userId);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setData(dataUtil);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

    @PostMapping("/receive")
    public BaseRespVo receiveCoupon(@RequestBody Map map){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        int couponId = (int) map.get("couponId");
        boolean flag =  couponService.receiveCoupon(couponId,userId);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

    @GetMapping("/selectlist")
    public BaseRespVo selectCouponList(@RequestParam("cartId") int cartId,
                                       @RequestParam("grouponRulesId") int grouponRulesId){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        List<CskaoyanMallCoupon> coupons =  couponService.selectCouponList(cartId,grouponRulesId,userId);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        baseRespVo.setData(coupons);
        return baseRespVo;
    }

    @PostMapping("/exchange")
    public BaseRespVo exchangeCoupon(@RequestBody Map map){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        String code = (String)map.get("code");
        boolean flag =  couponService.exchangeCoupon(code,userId);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }


}
