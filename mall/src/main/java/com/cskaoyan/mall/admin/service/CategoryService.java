package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;

import java.util.List;

public interface CategoryService {
    List<CategoryData> getCategory();

    List<L1Data> getCategoryLevel1();

    boolean updateCategory(CskaoyanMallCategory categoryData);

    boolean deleteCategory(CskaoyanMallCategory categoryData);

    CskaoyanMallCategory addCategory(CskaoyanMallCategory cskaoyanData);
}
