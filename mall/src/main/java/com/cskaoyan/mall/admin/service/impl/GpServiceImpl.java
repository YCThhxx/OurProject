package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGroupon;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGrouponMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGrouponRulesMapper;
import com.cskaoyan.mall.admin.service.GpService;
import com.cskaoyan.mall.admin.vo.ItemsVo;
import com.cskaoyan.mall.admin.vo.grouponvo.GrouponVo;
import com.cskaoyan.mall.admin.vo.grouponvo.SubGrouponsVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GpServiceImpl implements GpService {

    @Autowired
    CskaoyanMallGrouponMapper mallGrouponMapper;
    @Autowired
    CskaoyanMallGrouponRulesMapper mallGrouponRulesMapper;
    @Autowired
    CskaoyanMallGoodsMapper mallGoodsMapper;

    @Override
    public List<CskaoyanMallGrouponRules> list(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<CskaoyanMallGrouponRules> cskaoyanMallGrouponRules = mallGrouponRulesMapper.selectAllGrouponRulesByAddtime(sort, order,"");
        return cskaoyanMallGrouponRules;
    }

    @Override
    public long countAllRules() {
        long l = mallGrouponRulesMapper.countAllRules();
        return l;
    }

    @Override
    public long countAllGroupons() {
        long l = mallGrouponMapper.countAllGroupons();
        return l;
    }

    @Override
    public void updateRule(CskaoyanMallGoods goods, CskaoyanMallGrouponRules cskaoyanMallGrouponRules) {
        cskaoyanMallGrouponRules.setGoodsName(goods.getName());
        cskaoyanMallGrouponRules.setPicUrl(goods.getPicUrl());
        cskaoyanMallGrouponRules.setUpdateTime(new Date());
        mallGrouponRulesMapper.updateRule(cskaoyanMallGrouponRules);
    }

    @Override
    public void delete(Integer id) {
        mallGrouponRulesMapper.deleteById(id);
    }

    @Override
    public List<CskaoyanMallGrouponRules> listsearch(int page, int limit, String goodsId, String id, String asc) {
        PageHelper.startPage(page,limit);
        List<CskaoyanMallGrouponRules> cskaoyanMallGrouponRules = mallGrouponRulesMapper.selectAllGrouponRulesByAddtime(id, asc,goodsId);
        return cskaoyanMallGrouponRules;
    }

    @Override
    public void createRule(CskaoyanMallGoods goods, CskaoyanMallGrouponRules cskaoyanMallGrouponRules) {
        cskaoyanMallGrouponRules.setGoodsName(goods.getName());
        cskaoyanMallGrouponRules.setPicUrl(goods.getPicUrl());
        cskaoyanMallGrouponRules.setAddTime(new Date());
        cskaoyanMallGrouponRules.setUpdateTime(new Date());
        mallGrouponRulesMapper.createRule(cskaoyanMallGrouponRules);
    }

    @Override
    public ItemsVo listRecordSearch(int page, int limit, String goodsId, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<CskaoyanMallGrouponRules> cskaoyanMallGrouponRules = mallGrouponRulesMapper.selectAllGrouponRulesByAddtime(sort,order,goodsId);
        List<GrouponVo> grouponVos = new ArrayList<GrouponVo>();
        long i = 0;
        for (CskaoyanMallGrouponRules cskaoyanMallGrouponRule : cskaoyanMallGrouponRules) {
            GrouponVo grouponVo = new GrouponVo();
            SubGrouponsVo subGrouponsVo = new SubGrouponsVo();
            List<SubGrouponsVo> subGrouponsVos = new ArrayList<SubGrouponsVo>();
            CskaoyanMallGoods cskaoyanMallGoods = mallGoodsMapper.selectByPrimaryKey(cskaoyanMallGrouponRule.getGoodsId());
            grouponVo.setGoods(cskaoyanMallGoods);
            grouponVo.setRules(cskaoyanMallGrouponRule);
            List<CskaoyanMallGroupon> cskaoyanMallGroupons = mallGrouponMapper.selectAllGrouponsByRulesId(cskaoyanMallGrouponRule.getId());
            for (CskaoyanMallGroupon cskaoyanMallGroupon : cskaoyanMallGroupons) {
                if(cskaoyanMallGroupon.getCreatorUserId().equals(cskaoyanMallGroupon.getUserId())){
                    i = i+1;
                    grouponVo.setGroupon(cskaoyanMallGroupon);
                }else{
                    subGrouponsVo.setOrderId(cskaoyanMallGroupon.getOrderId());
                    subGrouponsVo.setUserId(cskaoyanMallGroupon.getUserId());
                    subGrouponsVos.add(subGrouponsVo);
                }
            }
            grouponVo.setSubGroupons(subGrouponsVos);
            if(cskaoyanMallGroupons.size()!=0){
                grouponVos.add(grouponVo);
            }
        }
        ItemsVo itemsVo = new ItemsVo(i,grouponVos);
        return itemsVo;
    }
}
