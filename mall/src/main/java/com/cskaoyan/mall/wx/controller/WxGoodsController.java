package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.WxGoodsService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.vo.goodsvo.CategoryVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsDetailVo;
import org.apache.shiro.SecurityUtils;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsListVo;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/goods")
public class WxGoodsController {

    @Autowired
    WxGoodsService goodsService;
    @Autowired
    WxUserService userService;

    Subject subject;

    @Autowired
    WxUserService wxUserService;

    @RequestMapping("count")
    public BaseResponseVo goodsCount(){
        int goodsCount = goodsService.goodsCount();
        Map result = new HashMap<>();
        result.put("goodsCount",goodsCount);
        return BaseResponseVo.ok(result);
    }

    @RequestMapping("list")
    public BaseResponseVo goodsList(boolean isNew,boolean isHot,Integer brandId,String keyword,int page,int size,String sort,String order,Integer categoryId){
        String name;
        if(isNew){ name = "new"; }
        else if(isHot){ name = "hot"; }
        else{ name = "other"; }
        if(keyword!=null){ keyword = "%"+keyword+"%"; }
        GoodsListVo goodsListVo = goodsService.getList(name,page,size,sort,order,brandId,keyword,categoryId);
        return BaseResponseVo.ok(goodsListVo);
    }

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
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        GoodsDetailVo goodsDetailVo = goodsService.goodsDetail(userId,id);
        if(goodsDetailVo==null){
            return BaseResponseVo.fail("没有该类别",400);
        }
        return BaseResponseVo.ok(goodsDetailVo);
    }

    @RequestMapping("related")
    public BaseResponseVo goodsList(int id){
        List<CskaoyanMallGoods> goodsList = goodsService.selectRelated(id);
        Map map = new HashMap();
        map.put("goodsList",goodsList);
        return BaseResponseVo.ok(map);
    }
}
