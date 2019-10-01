package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;

import java.util.List;

public interface CategoryService {
    List<CategoryData> getCategory();

    List<L1Data> getCategoryLevel1();
}
