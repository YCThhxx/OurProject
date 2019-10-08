package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.wx.vo.brandvo.BrandListVo;

public interface WxBrandService {
    BrandListVo brandList(int page, int size);

    CskaoyanMallBrand brandDetail(int id);
}
