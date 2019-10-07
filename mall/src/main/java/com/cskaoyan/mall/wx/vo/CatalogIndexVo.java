package com.cskaoyan.mall.wx.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;

import java.util.List;

public class CatalogIndexVo {

    private CskaoyanMallCategory currentCategory;

    private List<CskaoyanMallCategory> categoryList;

    private List<CskaoyanMallCategory> currentSubCategory;


    public CskaoyanMallCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CskaoyanMallCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<CskaoyanMallCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CskaoyanMallCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public List<CskaoyanMallCategory> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<CskaoyanMallCategory> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }
}
