package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallGoodsMapper;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CskaoyanMallGoodsMapper cskaoyanMallGoodsMapper;

    @Override
    public PageBean getListOfGoods(int page, int limit, String sort, String order, String goodsSn, String name) {
        String orderBy = sort+" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List<CskaoyanMallGoods> cskaoyanMallGoods = cskaoyanMallGoodsMapper.selectGoodsList(goodsSn, name);
        PageInfo<CskaoyanMallGoods> goodsPageInfo = new PageInfo<>(cskaoyanMallGoods);
        long total = goodsPageInfo.getTotal();
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(cskaoyanMallGoods);
        pageBean.setTotal(total);
        return pageBean;
    }
}
