package com.cskaoyan.mall.admin.controller;


import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.CatAndBrandInfo;
import com.cskaoyan.mall.admin.vo.GoodsDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("list")
    public BaseResponseVo listOfGoods(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String goodsSn = request.getParameter("goodsSn");
        String name = request.getParameter("name");
        page = page == null || page.trim().length() == 0 ? "1":page;
        limit = limit == null || limit.trim().length() == 0 ? "20":limit;

        int pagei = Integer.parseInt(page);
        int limiti = Integer.parseInt(limit);
        PageBean listOfGoods = goodsService.getListOfGoods(pagei,limiti,sort,order,goodsSn,name);
        BaseResponseVo ok = BaseResponseVo.ok(listOfGoods);
        return ok;
    }

    @RequestMapping("catAndBrand")
    public BaseResponseVo listOfCatAndBrand(){
        CatAndBrandInfo info = goodsService.getListOfCatAndBrand();
        BaseResponseVo ok = BaseResponseVo.ok(info);
        return ok;
    }

    @RequestMapping("detail")
    public BaseResponseVo detailOfGoods(HttpServletRequest request){
        String i = request.getParameter("id");
        int id = Integer.valueOf(i).intValue();
        GoodsDetailInfo goodsDetailInfo = goodsService.getDetailOfGoodsById(id);
        BaseResponseVo ok = BaseResponseVo.ok(goodsDetailInfo);
        return ok;
    }

    @RequestMapping("delete")
    public BaseResponseVo deleteGoods(@RequestBody CskaoyanMallGoods cskaoyanMallGoods){
        Integer id = cskaoyanMallGoods.getId();
        boolean flag = goodsService.deleteGoodsById(id);
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (flag){
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }else {
            baseResponseVo.setErrmsg("失败");
            baseResponseVo.setErrno(5000);
        }
        return baseResponseVo;
    }

    @RequestMapping("update")
    public BaseResponseVo updateGoods(@RequestBody GoodsDetailInfo goodsDetailInfo){
        boolean flag = goodsService.updateGoods(goodsDetailInfo);
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (flag){
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }else {
            baseResponseVo.setErrmsg("失败");
            baseResponseVo.setErrno(5000);
        }
        return baseResponseVo;
    }

    @RequestMapping("create")
    public void createGoods(@RequestBody GoodsDetailInfo goodsDetailInfo){
        goodsService.createGoods(goodsDetailInfo);
    }
}
