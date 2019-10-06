package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.config.UserTokenManager;
import com.cskaoyan.mall.wx.service.WxGoodsService;
import com.cskaoyan.mall.wx.vo.goodsvo.CategoryVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx/goods")
public class WxGoodsController {

    @Autowired
    WxGoodsService goodsService;

    @RequestMapping("count")
    public BaseResponseVo goodsCount(){
        int goodsCount = goodsService.goodsCount();
        Map result = new HashMap<>();
        result.put("goodsCount",goodsCount);
        return BaseResponseVo.ok(result);
    }

//    @RequestMapping("list")
//    public BaseResponseVo goodsList(){
//
//    }

    @RequestMapping("category")
    public BaseResponseVo goodsCategory(int id){
        CategoryVo categoryVo = goodsService.goodsCategory(id);
        if(categoryVo==null){
            return BaseResponseVo.fail("没有该类别",400);
        }
        return BaseResponseVo.ok(categoryVo);
    }

    @RequestMapping("detail")
    public BaseResponseVo goodsDetail(HttpServletRequest request, int id){
        String token = request.getHeader("X-cskaoyanmall-Admin-Token");
        Integer userId = UserTokenManager.getUserId(token);
        GoodsDetailVo goodsDetailVo = goodsService.goodsDetail(userId,id);
        if(goodsDetailVo==null){
            return BaseResponseVo.fail("没有该类别",400);
        }
        return BaseResponseVo.ok(goodsDetailVo);
    }

//    @RequestMapping("related")
//    public BaseResponseVo goodsList(){
//
//    }
}
