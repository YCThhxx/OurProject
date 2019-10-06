package com.cskaoyan.mall.wx.vo.goodsvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;

import java.util.List;

public class CategoryVo {

    private List<CskaoyanMallCategory> brotherCategory;

    private CskaoyanMallCategory currentCategory;

    private CskaoyanMallCategory parentCategory;

    public List<CskaoyanMallCategory> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<CskaoyanMallCategory> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    public CskaoyanMallCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CskaoyanMallCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public CskaoyanMallCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(CskaoyanMallCategory parentCategory) {
        this.parentCategory = parentCategory;
    }
}
