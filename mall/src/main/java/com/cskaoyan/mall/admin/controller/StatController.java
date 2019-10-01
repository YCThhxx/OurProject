package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.service.StService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.statvo.StatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/stat")
public class StatController {

    @Autowired
    StService stService;

    @GetMapping("user")
    public BaseResponseVo getUserStat(){
        StatVo statVo = stService.getUserStat();
        BaseResponseVo ok = BaseResponseVo.ok(statVo);
        return ok;
    }

    @GetMapping("order")
    public BaseResponseVo getOrderStat(){
        StatVo statVo = stService.getOrderStat();
        BaseResponseVo ok = BaseResponseVo.ok(statVo);
        return ok;
    }

    @GetMapping("goods")
    public BaseResponseVo getGoodsStat(){
        StatVo statVo = stService.getGoodsStat();
        BaseResponseVo ok = BaseResponseVo.ok(statVo);
        return ok;
    }
}
