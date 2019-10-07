package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.vo.AddRequest;
import com.cskaoyan.mall.wx.vo.CartResp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping("index")
    public BaseResponseVo index(){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        CartResp cartResp =cartService.queryCartByUsername(username);
        BaseResponseVo ok = BaseResponseVo.ok(cartResp);
        return ok;
    }
    @RequestMapping("add")
    public  BaseResponseVo add(AddRequest addRequest){
        Subject subject = SecurityUtils.getSubject();
        String principal = (String)subject.getPrincipal();
        cartService.add(addRequest,principal);
        BaseResponseVo ok = BaseResponseVo.ok(addRequest.getNumber());
        return ok;
    }
}
