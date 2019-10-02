package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCategoryMapper;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public boolean updateCategory(CskaoyanMallCategory categoryData) {
        Date date = new Date();
        categoryData.setUpdateTime(date);
        int i = cskaoyanMallCategoryMapper.updateCategory(categoryData);
        if(i != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCategory(CskaoyanMallCategory categoryData) {
        int i = cskaoyanMallCategoryMapper.deleteCategory(categoryData);
        if(i != 0){
            return true;
        }
        return false;
    }

    @Override
    public CskaoyanMallCategory addCategory(CskaoyanMallCategory cskaoyanData) {
        Date addTime = new Date();
        cskaoyanData.setAddTime(addTime);
        cskaoyanData.setUpdateTime(addTime);
        cskaoyanData.setDeleted(false);
        int id = cskaoyanMallCategoryMapper.insert(cskaoyanData);
        cskaoyanData.setId(id);
        return cskaoyanData;
    }

}
