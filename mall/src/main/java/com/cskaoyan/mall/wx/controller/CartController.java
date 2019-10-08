package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.CartService;
import com.cskaoyan.mall.wx.util.CheckData;
import com.cskaoyan.mall.wx.vo.*;
import com.cskaoyan.mall.wx.vo.homeIndex.CartCheckRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.Map;
import java.text.ParseException;

@RestController
@RequestMapping("/wx/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @RequestMapping("index")
    public BaseResponseVo index(){
        BaseResponseVo ok ;
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        if(username == null){
             ok = BaseResponseVo.fail("请先登入",1);

        }else {
            CartResp cartResp =cartService.queryCartByUsername(username);
            ok = BaseResponseVo.ok(cartResp);
        }
        return ok;
    }
    @RequestMapping("add")
    public  BaseResponseVo add(@RequestBody  AddRequest addRequest){
        Subject subject = SecurityUtils.getSubject();
        String username = (String)subject.getPrincipal();
        BaseResponseVo ok ;
        if(username == null){
            ok = BaseResponseVo.fail("请先登入",1);

        }else {
//            cartService.add(addRequest,username);
//            ok = BaseResponseVo.ok(addRequest.getNumber());
            cartService.add(addRequest,username);
            CartResp cartResp = cartService.queryCartByUsername(username);
            CartTotal cartTotal = cartResp.getCartTotal();
            int goodsCount = cartTotal.getGoodsCount();
            ok = BaseResponseVo.ok(addRequest.getNumber() + goodsCount - 1);
        }
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
        BaseResponseVo ok ;
        if(username == null){
            ok = BaseResponseVo.fail("请先登入",1);
        }else {
            try {
                cartId = cartService.fastAdd(username,addRequest);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ok = BaseResponseVo.ok(cartId);
        }
        return ok;
    }

    @GetMapping("checkout")
    public BaseResponseVo checkout(@Param("cartId") int cartId,
                                   @Param("addressId") int addressId,
                                   @Param("couponId") int couponId,
                                   @Param("grouponRulesId") int grouponRulesId){
        CheckData data = cartService.checkout(cartId,addressId,couponId,grouponRulesId);
        return BaseResponseVo.ok(data);
    }
}
