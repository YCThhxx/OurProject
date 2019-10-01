package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.mapper.CskaoyanMallCategoryMapper;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CskaoyanMallCategoryMapper cskaoyanMallCategoryMapper;

    @Override
    public List<CategoryData> getCategory() {
        List<CategoryData> cates = cskaoyanMallCategoryMapper.selectCategory();
        return cates;
    }

    @Override
    public List<L1Data> getCategoryLevel1() {
        List<L1Data> lists = cskaoyanMallCategoryMapper.selectByLevel();
        return lists;
    }

}
