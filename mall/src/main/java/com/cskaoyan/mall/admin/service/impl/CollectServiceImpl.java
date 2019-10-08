package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCollectMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.admin.service.CollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Tyj
 * @date 2019/10/4 20:29
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CskaoyanMallCollectMapper cskaoyanMallCollectMapper;
    @Autowired
    CskaoyanMallGoodsMapper cskaoyanMallGoodsMapper;


    //获得收藏列表
    @Override
    public PageBean2 getCollectList(int type, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //先找出收藏品中的商品id
        CskaoyanMallCollectExample collectExample = new CskaoyanMallCollectExample();
        List<CskaoyanMallCollect> cskaoyanMallCollects = cskaoyanMallCollectMapper.selectByExample(collectExample);
        List<CskaoyanMallGoods> cskaoyanMallGoods = new ArrayList<>();
        for (CskaoyanMallCollect cskaoyanMallCollect : cskaoyanMallCollects) {
            Integer valueId = cskaoyanMallCollect.getValueId();
            CskaoyanMallGoods cskaoyanMallGood = cskaoyanMallGoodsMapper.queryGoodsByValueId(valueId);
            cskaoyanMallGood.setType(0);
            cskaoyanMallGoods.add(cskaoyanMallGood);
        }
        long total = new PageInfo<>(cskaoyanMallGoods).getTotal();
        PageBean2 pageBean2 = new PageBean2();
        pageBean2.setCollectList(cskaoyanMallGoods);
        pageBean2.setTotalPages(total);
        return pageBean2;
    }


    //添加至收藏
    @Override
    public Map<String, String> addCollectList(int type, int valueId,Integer userId) {
        Map<String, String> map = new HashMap<String, String>();
        CskaoyanMallCollectExample collectExample = new CskaoyanMallCollectExample();
        CskaoyanMallCollectExample.Criteria criteria = collectExample.createCriteria();
        int i = cskaoyanMallCollectMapper.hasGoods(valueId);
        if(i==1){
            map.put("type","delete");
            criteria.andValueIdEqualTo(valueId);
            cskaoyanMallCollectMapper.deleteByExample(collectExample);
        }else {
            map.put("type","add");
            CskaoyanMallCollect cskaoyanMallCollect = new CskaoyanMallCollect();
            cskaoyanMallCollect.setType((byte)type);
            Date date = new Date();
            cskaoyanMallCollect.setAddTime(date);
            cskaoyanMallCollect.setUpdateTime(date);
            cskaoyanMallCollect.setValueId(valueId);
            cskaoyanMallCollect.setDeleted(false);
            //获取用户id
            cskaoyanMallCollect.setUserId(userId);

            cskaoyanMallCollectMapper.insert(cskaoyanMallCollect);
        }
        return map;
    }
}
