package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallOrderGoods;

public interface CskaoyanMallOrderGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallOrderGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallOrderGoods record);

    int updateByPrimaryKey(CskaoyanMallOrderGoods record);
}