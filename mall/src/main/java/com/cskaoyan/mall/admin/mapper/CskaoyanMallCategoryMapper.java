package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCategory;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCategoryExample;
import com.cskaoyan.mall.admin.vo.CategoryData;
import com.cskaoyan.mall.admin.vo.CategoryInfo;
import com.cskaoyan.mall.admin.vo.L1Data;
import com.cskaoyan.mall.wx.vo.homeIndex.FloorGoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select id,name from cskaoyan_mall_category where pid=0 limit 4")
    List<FloorGoodsInfo> selectFirstCategories4();

    @Select("select id from cskaoyan_mall_category where pid=#{pid} limit 1")
    Integer selectIdByPid(@Param("pid") Integer pid);

    CskaoyanMallCategory selectGroupByCategoryId(Integer categoryId);


//    FloorGoodsInfo selectFloorGoodsInfo(@Param("pid") Integer pid);

}
