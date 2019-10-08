package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallFootprintMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.wx.service.FootprintService;
import com.cskaoyan.mall.wx.vo.FootData;
import com.cskaoyan.mall.wx.vo.FootprintData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FootPrintServiceImpl implements FootprintService {

    @Autowired
    CskaoyanMallFootprintMapper footprintMapper;

    @Autowired
    CskaoyanMallGoodsMapper goodsMapper;

    @Override
    public FootprintData getFootprint(int page, int size,int userId) {
        PageHelper.startPage(page,size);
        List<Integer> goodsId =  footprintMapper.selectGoodsId(userId);
        List<FootData> footDataList = new ArrayList<>();
        for (Integer goodId : goodsId) {
            CskaoyanMallGoods goods =goodsMapper.selectByPrimaryKey(goodId);
            BigDecimal retailPrice = goods.getRetailPrice();
            Date addTime = goods.getAddTime();
            String brief = goods.getBrief();
            String goodsName = goods.getName();
            String picUrl = goods.getPicUrl();
            FootData footData = new FootData();
            footData.setAddTime(addTime);
            footData.setBrief(brief);
            footData.setGoodsId(goodId);
            footData.setPicUrl(picUrl);
            footData.setName(goodsName);
            footData.setRetailPrice(retailPrice);
            footDataList.add(footData);
        }
        int total = goodsId.size();
        FootprintData footprintData = new FootprintData();
        footprintData.setFootprintList(footDataList);
        footprintData.setTotalPages(total);
        return footprintData;
    }
}
