package com.cskaoyan.mall.wx.vo.brandvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;

import java.util.List;

public class BrandListVo {

    List<CskaoyanMallBrand> brandList;
    int totalPages;

    public List<CskaoyanMallBrand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<CskaoyanMallBrand> brandList) {
        this.brandList = brandList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
