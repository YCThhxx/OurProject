package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsExample;
import com.cskaoyan.mall.wx.vo.homeIndex.FloorGoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CskaoyanMallGoodsMapper {
    long countByExample(CskaoyanMallGoodsExample example);

    int deleteByExample(CskaoyanMallGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallGoods record);

    int insertSelective(CskaoyanMallGoods record);

    List<CskaoyanMallGoods> selectByExampleWithBLOBs(CskaoyanMallGoodsExample example);

    List<CskaoyanMallGoods> selectByExample(CskaoyanMallGoodsExample example);

    CskaoyanMallGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallGoods record, @Param("example") CskaoyanMallGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") CskaoyanMallGoods record, @Param("example") CskaoyanMallGoodsExample example);

    int updateByExample(@Param("record") CskaoyanMallGoods record, @Param("example") CskaoyanMallGoodsExample example);

    int updateByPrimaryKeySelective(CskaoyanMallGoods record);

    int updateByPrimaryKeyWithBLOBs(CskaoyanMallGoods record);

    int updateByPrimaryKey(CskaoyanMallGoods record);

    List<CskaoyanMallGoods> selectGoodsList(@Param("goodsSn") String goodsSn, @Param("name") String name);


    int selectGoodsTotal();

    @Select("select id,name,brief,pic_url as picUrl,is_new as isNew,is_hot as isHot,counter_price as counterPrice,retail_price as retailPrice from cskaoyan_mall_goods where category_id=#{cid} limit 2")
    List<CskaoyanMallGoods> selectGoodsByCategory2(@Param("cid") Integer id);
}
