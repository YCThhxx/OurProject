package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCategoryExample;
import java.util.List;

import com.cskaoyan.mall.admin.vo.CategoryInfo;
import org.apache.ibatis.annotations.Param;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.L1Data;

import java.util.List;

public interface CskaoyanMallCategoryMapper {
    long countByExample(CskaoyanMallCategoryExample example);

    int deleteByExample(CskaoyanMallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallCategory record);

    int insertSelective(CskaoyanMallCategory record);

    List<CskaoyanMallCategory> selectByExample(CskaoyanMallCategoryExample example);

    CskaoyanMallCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallCategory record, @Param("example") CskaoyanMallCategoryExample example);

    int updateByExample(@Param("record") CskaoyanMallCategory record, @Param("example") CskaoyanMallCategoryExample example);

    int updateByPrimaryKeySelective(CskaoyanMallCategory record);

    int updateByPrimaryKey(CskaoyanMallCategory record);

    List<CategoryInfo> selectCatListForGoods();

    List<CategoryData> selectCategory();

    List<L1Data> selectByLevel();

    int updateCategory(CskaoyanMallCategory categoryData);

    int deleteCategory(CskaoyanMallCategory categoryData);

    List<CskaoyanMallCategory> selectByPidOrderId(int id);
}
