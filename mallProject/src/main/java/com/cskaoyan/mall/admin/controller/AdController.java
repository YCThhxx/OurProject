package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.AdService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/ad")
public class AdController {

    @Autowired
    AdService adService;
    /**
     * 根据条件获取广告列表
     * @param request
     * @return
     */
    @RequestMapping("list")
    public BaseResponseVo listOfAd(HttpServletRequest request){
        String pages = request.getParameter("page");
        String pageSizes = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        pages = pages == null || pages.trim().length() == 0 ? "1":pages;
        pageSizes = pageSizes == null || pageSizes.trim().length() == 0 ? "20":pageSizes;

        //得到广告标题
        String adName = request.getParameter("name");
        //得到广告内容
        String adContent = request.getParameter("content");

        int page = Integer.parseInt(pages);
        int pageSize = Integer.parseInt(pageSizes);
        PageBean listOfAd = adService.getListOfAd(page, pageSize, sort, order,adName,adContent);
        BaseResponseVo ok = BaseResponseVo.ok(listOfAd);
        return ok;
    }

}
