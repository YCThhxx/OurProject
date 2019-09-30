package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallOrderGoods;

public interface CskaoyanMallOrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallOrderGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallOrderGoods record);

    int updateByPrimaryKey(CskaoyanMallOrderGoods record);
}