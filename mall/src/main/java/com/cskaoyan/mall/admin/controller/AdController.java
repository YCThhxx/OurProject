package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.AdService;
import com.cskaoyan.mall.admin.utils.PagingUtil;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 
     * @return
     */
    @RequestMapping("list")
    public BaseResponseVo listOfAd(String page,String limit,String sort,String order,String name,String content){
        PageBean listOfAd = adService.getListOfAd(PagingUtil.returnPage(page), PagingUtil.returnPageSize(limit), sort, order,name,content);
        BaseResponseVo ok = BaseResponseVo.ok(listOfAd);
        return ok;
    }
    @RequestMapping("delete")
    public BaseResponseVo delete(@RequestBody CskaoyanMallAd ad){
        adService.delete(ad.getId());
        BaseResponseVo ok = BaseResponseVo.ok(null);
        return  ok;
    }
    @RequestMapping("update")
    public BaseResponseVo update(@RequestBody CskaoyanMallAd ad){
        adService.update(ad);
        BaseResponseVo ok = BaseResponseVo.ok(ad);
        return  ok;
    }
    @RequestMapping("create")
    public  BaseResponseVo create(@RequestBody CskaoyanMallAd ad){
        adService.create(ad);
        BaseResponseVo ok = BaseResponseVo.ok(ad);
        return  ok;
    }
}
