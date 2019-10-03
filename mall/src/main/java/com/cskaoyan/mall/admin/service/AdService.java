package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.PageBean;

import java.util.List;

/**
 * author : Nianjie Jing
 * creat time : 2019/9/30
 * e-mail : clemeting@qq.com
 */
public interface AdService {
    PageBean getListOfAd(int page, int pageSize, String sort, String order,String adName, String adContent);

    void delete(Integer id);

    void update(CskaoyanMallAd ad);

    void create(CskaoyanMallAd ad);
}
