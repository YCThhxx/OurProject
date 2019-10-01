package com.cskaoyan.mall.admin.vo;

import java.util.List;

public class CatAndBrandInfo {
    List<CategoryInfo> categoryList;
    List<BrandInfo> brandList;

    public List<CategoryInfo> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryInfo> categoryList) {
        this.categoryList = categoryList;
    }

    public List<BrandInfo> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<BrandInfo> brandList) {
        this.brandList = brandList;
    }
}
