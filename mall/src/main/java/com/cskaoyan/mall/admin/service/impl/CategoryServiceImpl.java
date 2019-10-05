package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCategoryExample;
import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCategoryMapper;
import com.cskaoyan.mall.admin.service.CategoryService;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;
import com.cskaoyan.mall.wx.vo.CatalogCurrentVo;
import com.cskaoyan.mall.wx.vo.CatalogIndexVo;
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

    @Override
    public CatalogIndexVo getCatalogIndex() {
        CatalogIndexVo catalogIndexVo = new CatalogIndexVo();
        CskaoyanMallCategoryExample categoryExample = new CskaoyanMallCategoryExample();
        categoryExample.createCriteria().andPidEqualTo(0);
        List<CskaoyanMallCategory> mallCategories = cskaoyanMallCategoryMapper.selectByExample(categoryExample);
        CskaoyanMallCategory currentCategory = mallCategories.get(0);
        Integer id = currentCategory.getId();
        CskaoyanMallCategoryExample categoryExample1 = new CskaoyanMallCategoryExample();
        categoryExample1.createCriteria().andPidEqualTo(id);
        List<CskaoyanMallCategory> currentSubCategory = cskaoyanMallCategoryMapper.selectByExample(categoryExample1);
        catalogIndexVo.setCategoryList(mallCategories);
        catalogIndexVo.setCurrentCategory(currentCategory);
        catalogIndexVo.setCurrentSubCategory(currentSubCategory);
        return catalogIndexVo;
    }

    @Override
    public CatalogCurrentVo getCatalogCurrent(Integer id) {
        CatalogCurrentVo catalogCurrentVo = new CatalogCurrentVo();
        CskaoyanMallCategory currentCategory = cskaoyanMallCategoryMapper.selectByPrimaryKey(id);
        CskaoyanMallCategoryExample categoryExample = new CskaoyanMallCategoryExample();
        categoryExample.createCriteria().andPidEqualTo(id);
        List<CskaoyanMallCategory> mallCategories = cskaoyanMallCategoryMapper.selectByExample(categoryExample);
        catalogCurrentVo.setCurrentCategory(currentCategory);
        catalogCurrentVo.setCurrentSubCategory(mallCategories);
        return catalogCurrentVo;
    }

}
