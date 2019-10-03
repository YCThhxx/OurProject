package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.admin.service.GpService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.grouponvo.GrouponVo;
import com.cskaoyan.mall.admin.vo.ItemsVo;
import com.cskaoyan.mall.admin.vo.grouponvo.GrouponVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/groupon")
public class GrouponController {

    @Autowired
    GpService gpService;
    @Autowired
    CskaoyanMallGoodsMapper mallGoodsMapper;

    @GetMapping(value = "list",params = {"page","limit","sort","order"})
    public BaseResponseVo list(int page, int limit, String sort, String order){
        List<CskaoyanMallGrouponRules> rules = gpService.list(page,limit,sort,order);
        long total = gpService.countAllRules();
        ItemsVo itemsVo = new ItemsVo(total,rules);
        BaseResponseVo ok = BaseResponseVo.ok(itemsVo);
        return ok;
    }

    @GetMapping(value = "list",params = {"page","limit","goodsId","sort","order"})
    public BaseResponseVo list(int page, int limit, String goodsId, String sort, String order){
        List<CskaoyanMallGrouponRules> rules = gpService.listsearch(page,limit,goodsId,"id","asc");
        long total = gpService.countAllRules();
        ItemsVo itemsVo = new ItemsVo(total,rules);
        BaseResponseVo ok = BaseResponseVo.ok(itemsVo);
        return ok;
    }

    @GetMapping(value = "listRecord",params = {"page","limit","sort","order"})
    public BaseResponseVo listRecord(int page, int limit, String sort, String order){
        ItemsVo itemsVo = gpService.listRecordSearch(page,limit,"",sort,order);
        BaseResponseVo ok = BaseResponseVo.ok(itemsVo);
        return ok;
    }

    @GetMapping(value = "listRecord",params = {"page","limit","goodsId","sort","order"})
    public BaseResponseVo listRecord(int page, int limit, String goodsId, String sort, String order){
        ItemsVo itemsVo = gpService.listRecordSearch(page,limit,goodsId,sort,order);
        BaseResponseVo ok = BaseResponseVo.ok(itemsVo);
        return ok;
    }

    @PostMapping("update")
    public BaseResponseVo update(@RequestBody CskaoyanMallGrouponRules cskaoyanMallGrouponRules){
        CskaoyanMallGoods goods = mallGoodsMapper.selectByPrimaryKey(cskaoyanMallGrouponRules.getGoodsId());
        //如果没有该商品或者团购开始时间比结束时间晚就更新返回失败
        if(goods==null||cskaoyanMallGrouponRules.getAddTime().after(cskaoyanMallGrouponRules.getExpireTime())){
            return BaseResponseVo.fail("参数值不正确",402);
        }else{
            gpService.updateRule(goods,cskaoyanMallGrouponRules);
            return BaseResponseVo.ok();
        }
    }

    @PostMapping("delete")
    public BaseResponseVo delete(@RequestBody CskaoyanMallGrouponRules cskaoyanMallGrouponRules){
        gpService.delete(cskaoyanMallGrouponRules.getId());
        return BaseResponseVo.ok();
    }



    @PostMapping("create")
    public BaseResponseVo create(@RequestBody CskaoyanMallGrouponRules cskaoyanMallGrouponRules){
        CskaoyanMallGoods goods = mallGoodsMapper.selectByPrimaryKey(cskaoyanMallGrouponRules.getGoodsId());
        //如果没有该商品或者团购开始时间比结束时间晚就更新返回失败
        if(goods==null||new Date().after(cskaoyanMallGrouponRules.getExpireTime())){
            return BaseResponseVo.fail("参数值不正确",402);
        }else{
            gpService.createRule(goods,cskaoyanMallGrouponRules);
            return BaseResponseVo.ok();
        }
    }


}
