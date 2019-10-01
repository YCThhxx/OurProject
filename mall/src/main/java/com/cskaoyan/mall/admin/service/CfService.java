package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.configvo.ExpressConfigVo;
import com.cskaoyan.mall.admin.vo.configvo.MallConfigVo;
import com.cskaoyan.mall.admin.vo.configvo.OrderConfigVo;
import com.cskaoyan.mall.admin.vo.configvo.WxConfigVo;

/**
 * author : cwl
 * creat time : 2019/9/30
 * e-mail : 13427537790@163.com
 */
public interface CfService {

    MallConfigVo getMallConfig();

    ExpressConfigVo getExpressConfig();

    OrderConfigVo getOrderConfig();

    WxConfigVo getWxConfig();

    void mallPostConfig(MallConfigVo mallConfigVo);

    void expressPostConfig(ExpressConfigVo expressConfigVo);

    void orderPostConfig(OrderConfigVo orderConfigVo);

    void wxPostConfig(WxConfigVo wxConfigVo);
}
