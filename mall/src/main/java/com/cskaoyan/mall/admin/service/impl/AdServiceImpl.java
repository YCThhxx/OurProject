package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallAdMapper;
import com.cskaoyan.mall.admin.service.AdService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
