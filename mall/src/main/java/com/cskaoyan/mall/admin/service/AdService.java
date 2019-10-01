package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.PageBean;

public interface AdService {
    PageBean getListOfAd(int page, int pageSize, String sort, String order,String adName, String adContent);
}
