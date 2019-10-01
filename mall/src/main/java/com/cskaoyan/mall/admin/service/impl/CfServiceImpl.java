package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallSystem;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallSystemMapper;
import com.cskaoyan.mall.admin.service.CfService;
import com.cskaoyan.mall.admin.vo.configvo.ExpressConfigVo;
import com.cskaoyan.mall.admin.vo.configvo.MallConfigVo;
import com.cskaoyan.mall.admin.vo.configvo.OrderConfigVo;
import com.cskaoyan.mall.admin.vo.configvo.WxConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class CfServiceImpl implements CfService {

    @Autowired
    CskaoyanMallSystemMapper mapper;

    @Override
    public MallConfigVo getMallConfig() {
        List<CskaoyanMallSystem> cskaoyanMallSystems = mapper.selectAll();
        MallConfigVo mallConfigVo = new MallConfigVo();
        for (CskaoyanMallSystem cskaoyanMallSystem : cskaoyanMallSystems) {
            switch (cskaoyanMallSystem.getKeyName()){
                case "cskaoyan_mall_mall_phone" : mallConfigVo.setCskaoyan_mall_mall_phone(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_mall_address" : mallConfigVo.setCskaoyan_mall_mall_address(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_mall_name" : mallConfigVo.setCskaoyan_mall_mall_name(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_mall_qq" : mallConfigVo.setCskaoyan_mall_mall_qq(cskaoyanMallSystem.getKeyValue());
                    break;
            }
        }
        return mallConfigVo;
    }

    @Override
    public ExpressConfigVo getExpressConfig() {
        List<CskaoyanMallSystem> cskaoyanMallSystems = mapper.selectAll();
        ExpressConfigVo expressConfigVo = new ExpressConfigVo();
        for (CskaoyanMallSystem cskaoyanMallSystem : cskaoyanMallSystems) {
            switch (cskaoyanMallSystem.getKeyName()){
                case "cskaoyan_mall_express_freight_min" : expressConfigVo.setCskaoyan_mall_express_freight_min(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_express_freight_value" : expressConfigVo.setCskaoyan_mall_express_freight_value(cskaoyanMallSystem.getKeyValue());
                    break;
            }
        }
        return expressConfigVo;
    }

    @Override
    public OrderConfigVo getOrderConfig() {
        List<CskaoyanMallSystem> cskaoyanMallSystems = mapper.selectAll();
        OrderConfigVo orderConfigVo = new OrderConfigVo();
        for (CskaoyanMallSystem cskaoyanMallSystem : cskaoyanMallSystems) {
            switch (cskaoyanMallSystem.getKeyName()){
                case "cskaoyan_mall_order_comment" : orderConfigVo.setCskaoyan_mall_order_comment(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_order_unconfirm" : orderConfigVo.setCskaoyan_mall_order_unconfirm(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_order_unpaid" : orderConfigVo.setCskaoyan_mall_order_unpaid(cskaoyanMallSystem.getKeyValue());
                    break;
            }
        }
        return orderConfigVo;
    }

    @Override
    public WxConfigVo getWxConfig() {
        List<CskaoyanMallSystem> cskaoyanMallSystems = mapper.selectAll();
        WxConfigVo wxConfigVo = new WxConfigVo();
        for (CskaoyanMallSystem cskaoyanMallSystem : cskaoyanMallSystems) {
            switch (cskaoyanMallSystem.getKeyName()){
                case "cskaoyan_mall_wx_catlog_goods" : wxConfigVo.setCskaoyan_mall_wx_catlog_goods(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_wx_catlog_list" : wxConfigVo.setCskaoyan_mall_wx_catlog_list(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_wx_index_brand" : wxConfigVo.setCskaoyan_mall_wx_index_brand(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_wx_index_hot" : wxConfigVo.setCskaoyan_mall_wx_index_hot(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_wx_index_new" : wxConfigVo.setCskaoyan_mall_wx_index_new(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_wx_index_topic" : wxConfigVo.setCskaoyan_mall_wx_index_topic(cskaoyanMallSystem.getKeyValue());
                    break;
                case "cskaoyan_mall_wx_share" : wxConfigVo.setCskaoyan_mall_wx_share(cskaoyanMallSystem.getKeyValue());
                    break;
            }
        }
        return wxConfigVo;
    }

    @Override
    public void mallPostConfig(MallConfigVo mallConfigVo) {
        Date date = new Date();
        mapper.updateConfigInfo("cskaoyan_mall_mall_phone",mallConfigVo.getCskaoyan_mall_mall_phone(),date);
        mapper.updateConfigInfo("cskaoyan_mall_mall_qq",mallConfigVo.getCskaoyan_mall_mall_qq(),date);
        mapper.updateConfigInfo("cskaoyan_mall_mall_address",mallConfigVo.getCskaoyan_mall_mall_address(),date);
        mapper.updateConfigInfo("cskaoyan_mall_mall_name",mallConfigVo.getCskaoyan_mall_mall_name(),date);
    }

    @Override
    public void expressPostConfig(ExpressConfigVo expressConfigVo) {
        Date date = new Date();
        mapper.updateConfigInfo("cskaoyan_mall_express_freight_value",expressConfigVo.getCskaoyan_mall_express_freight_value(),date);
        mapper.updateConfigInfo("cskaoyan_mall_express_freight_min",expressConfigVo.getCskaoyan_mall_express_freight_min(),date);
    }

    @Override
    public void orderPostConfig(OrderConfigVo orderConfigVo) {
        Date date = new Date();
        mapper.updateConfigInfo("cskaoyan_mall_order_comment",orderConfigVo.getCskaoyan_mall_order_comment(),date);
        mapper.updateConfigInfo("cskaoyan_mall_order_unconfirm",orderConfigVo.getCskaoyan_mall_order_unconfirm(),date);
        mapper.updateConfigInfo("cskaoyan_mall_order_unpaid",orderConfigVo.getCskaoyan_mall_order_unpaid(),date);
    }

    @Override
    public void wxPostConfig(WxConfigVo wxConfigVo) {
        Date date = new Date();
        mapper.updateConfigInfo("cskaoyan_mall_wx_catlog_goods",wxConfigVo.getCskaoyan_mall_wx_catlog_goods(),date);
        mapper.updateConfigInfo("cskaoyan_mall_wx_catlog_list",wxConfigVo.getCskaoyan_mall_wx_catlog_list(),date);
        mapper.updateConfigInfo("cskaoyan_mall_wx_index_brand",wxConfigVo.getCskaoyan_mall_wx_index_brand(),date);
        mapper.updateConfigInfo("cskaoyan_mall_wx_index_hot",wxConfigVo.getCskaoyan_mall_wx_index_hot(),date);
        mapper.updateConfigInfo("cskaoyan_mall_wx_index_topic",wxConfigVo.getCskaoyan_mall_wx_index_topic(),date);
        mapper.updateConfigInfo("cskaoyan_mall_wx_index_new",wxConfigVo.getCskaoyan_mall_wx_index_new(),date);
        mapper.updateConfigInfo("cskaoyan_mall_wx_share",wxConfigVo.getCskaoyan_mall_wx_share(),date);
    }


}
