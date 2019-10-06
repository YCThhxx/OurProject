package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;

import java.util.List;

public class CatalogCurrentVo {

    private CskaoyanMallCategory currentCategory;

    private List<CskaoyanMallCategory> currentSubCategory;

    public CskaoyanMallCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CskaoyanMallCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<CskaoyanMallCategory> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<CskaoyanMallCategory> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }
}
