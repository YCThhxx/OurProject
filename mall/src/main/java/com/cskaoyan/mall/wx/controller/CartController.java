package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.vo.*;
import com.cskaoyan.mall.wx.vo.homeIndex.CartCheckRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.text.ParseException;

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
    public  BaseResponseVo add(@RequestBody  AddRequest addRequest){
        Subject subject = SecurityUtils.getSubject();
        String principal = (String)subject.getPrincipal();
        cartService.add(addRequest,principal);
        BaseResponseVo ok = BaseResponseVo.ok(addRequest.getNumber());
        return ok;
    }
    @RequestMapping("delete")
    public BaseResponseVo delete(@RequestBody CartDeleteRequest cartDeleteRequest){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        cartService.delete(cartDeleteRequest);
        
        CartResp cartResp =cartService.queryCartByUsername(username);
        BaseResponseVo ok = BaseResponseVo.ok(cartResp);
        return ok;
    }
    @RequestMapping("update")
    public BaseResponseVo update(@RequestBody CartUpdateRequest cartDeleteRequest){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        cartService.update(cartDeleteRequest.getProductId(),cartDeleteRequest.getNumber(),username);
        BaseResponseVo ok = BaseResponseVo.ok();
        return ok;
    }
    @RequestMapping("checked")
    public BaseResponseVo check(@RequestBody CartCheckRequest cartCheckRequest){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        CartResp cartResp =cartService.check(username,cartCheckRequest);
        BaseResponseVo ok = BaseResponseVo.ok(cartResp);
        return ok;
    }
    @RequestMapping("goodscount")
    public BaseResponseVo goodsCount(){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        int goodsSum =cartService.goodscount(username);
        BaseResponseVo ok = BaseResponseVo.ok(goodsSum);
        return ok;
    }
    @RequestMapping("fastadd")
    public BaseResponseVo fastAdd(@RequestBody AddRequest addRequest){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        int cartId = 0;
        try {
            cartId = cartService.fastAdd(username,addRequest);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BaseResponseVo ok = BaseResponseVo.ok(cartId);
        return ok;
    }
//    @RequestMapping("checkout")
//    public BaseResponseVo checkout(int cartId,int addressId,int couponId,int grouponRulesId){
//        Subject subject = SecurityUtils.getSubject();
//        String username = (String)subject.getPrincipal();
//        CartCheckoutResp  cartCheckoutResp = cartService.checkOut(username,cartId,addressId,couponId,grouponRulesId);
//        BaseResponseVo ok = BaseResponseVo.ok(cartCheckoutResp);
//        return ok;
//    } 
}
