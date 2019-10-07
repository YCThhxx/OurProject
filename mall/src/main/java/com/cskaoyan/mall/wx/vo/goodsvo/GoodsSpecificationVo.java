package com.cskaoyan.mall.wx.vo.goodsvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsSpecification;

import java.util.List;

public class GoodsSpecificationVo {

    String name;
    List<CskaoyanMallGoodsSpecification> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CskaoyanMallGoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<CskaoyanMallGoodsSpecification> valueList) {
        this.valueList = valueList;
    }
}
