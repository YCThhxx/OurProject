package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.PageBean;

import java.util.List;

public interface AdService {
    PageBean getListOfAd(int page, int pageSize, String sort, String order,String adName, String adContent);
}
