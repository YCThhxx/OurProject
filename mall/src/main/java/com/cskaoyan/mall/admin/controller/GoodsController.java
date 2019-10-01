package com.cskaoyan.mall.admin.controller;


import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
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
        BaseResponseVo baseResponseVo = new BaseResponseVo();
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
}
