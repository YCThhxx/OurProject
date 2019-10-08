package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.mapper.CskaoyanMallFootprintMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.wx.service.FootprintService;
import com.cskaoyan.mall.wx.vo.FootData;
import com.cskaoyan.mall.wx.vo.FootprintData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootPrintServiceImpl implements FootprintService {

    @Autowired
    CskaoyanMallFootprintMapper footprintMapper;

    @Autowired
    CskaoyanMallGoodsMapper goodsMapper;

    @Override
    public FootprintData getFootprint(int page, int size) {
        PageHelper.startPage(page,size);
        List<FootData> footDataList =  footprintMapper.selectFootprint();
        PageInfo<FootData> pageInfo = new PageInfo<>();
        long total = pageInfo.getTotal();
        FootprintData footprintData = new FootprintData();
        footprintData.setFootprintList(footDataList);
        footprintData.setTotalPages((int) total);
        return footprintData;
    }
}
