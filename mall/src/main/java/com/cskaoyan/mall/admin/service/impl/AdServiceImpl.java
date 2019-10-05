package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallAdMapper;
import com.cskaoyan.mall.admin.service.AdService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author : Nianjie Jing
 * creat time : 2019/9/30
 * e-mail : clemeting@qq.com
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    CskaoyanMallAdMapper cskaoyanMallAdMapper;

    /**
     * @param page
     * @param pageSize
     * @param sort
     * @param order
     * @return
     */
    @Override
    public PageBean getListOfAd(int page, int pageSize, String sort, String order, String adName, String adContent) {
        String orderBy = sort +" " + order;
        PageHelper.startPage(page, pageSize, orderBy);
        List<CskaoyanMallAd> mallAds = cskaoyanMallAdMapper.selectByPageAndPageSize(adName,adContent);
        PageInfo<CskaoyanMallAd> adPageInfo = new PageInfo<>(mallAds);
        long total = adPageInfo.getTotal();
        PageBean<List> pageListBean = new PageBean<>();
        pageListBean.setItems(mallAds);
        pageListBean.setTotal(total);
        return pageListBean;
    }

    @Override
    public void delete(Integer id) {
        cskaoyanMallAdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CskaoyanMallAd ad) {
        ad.setUpdateTime(new Date());
        cskaoyanMallAdMapper.updateByPrimaryKeySelective(ad);
    }

    @Override
    public void create(CskaoyanMallAd ad) {
        ad.setAddTime(new Date());
        ad.setUpdateTime(new Date());
        cskaoyanMallAdMapper.insertAd(ad);
    }
}
