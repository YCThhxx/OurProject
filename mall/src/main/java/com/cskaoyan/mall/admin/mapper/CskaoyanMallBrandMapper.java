package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.bean.CskaoyanMallBrandExample;
import com.cskaoyan.mall.admin.vo.BrandInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CskaoyanMallBrandMapper {
    long countByExample(CskaoyanMallBrandExample example);

    int deleteByExample(CskaoyanMallBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallBrand record);

    int insertSelective(CskaoyanMallBrand record);

    List<CskaoyanMallBrand> selectByExample(CskaoyanMallBrandExample example);

    CskaoyanMallBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallBrand record, @Param("example") CskaoyanMallBrandExample example);

    int updateByExample(@Param("record") CskaoyanMallBrand record, @Param("example") CskaoyanMallBrandExample example);

    int updateByPrimaryKeySelective(CskaoyanMallBrand record);

    int updateByPrimaryKey(CskaoyanMallBrand record);

    List<CskaoyanMallBrand> findAllBrandByPage(Integer id,String name);

    List<BrandInfo> selectBrandListForGoods();

    int deleteBrand(CskaoyanMallBrand categoryData);

    @Select("select id,name,`desc`,pic_url as picUrl,floor_price as floorPrice from cskaoyan_mall_brand limit 4")
    List<CskaoyanMallBrand> selectBrandListLimit4();
}
