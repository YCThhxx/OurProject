package com.cskaoyan.mall.admin.vo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsAttribute;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsProduct;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGoodsSpecification;

import java.util.List;

public class GoodsDetailInfo {
    Integer[] categoryIds;
    CskaoyanMallGoods goods;
    List<CskaoyanMallGoodsAttribute> attributes;
    List<CskaoyanMallGoodsSpecification> specifications;
    List<CskaoyanMallGoodsProduct> products;

    public Integer[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Integer[] categoryIds) {
        this.categoryIds = categoryIds;
    }

    public CskaoyanMallGoods getGoods() {
        return goods;
    }

    public void setGoods(CskaoyanMallGoods goods) {
        this.goods = goods;
    }

    public List<CskaoyanMallGoodsAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CskaoyanMallGoodsAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<CskaoyanMallGoodsSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<CskaoyanMallGoodsSpecification> specifications) {
        this.specifications = specifications;
    }

    public List<CskaoyanMallGoodsProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CskaoyanMallGoodsProduct> products) {
        this.products = products;
    }
}
