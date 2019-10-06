package com.cskaoyan.mall.wx.vo.goodsvo;

import com.cskaoyan.mall.admin.bean.*;

import java.util.List;

public class GoodsDetailVo {
    List<CskaoyanMallGoodsAttribute> attribute;
    CskaoyanMallBrand brand;
    GoodsCommentVo comment;
    List<CskaoyanMallGrouponRules> groupon;
    CskaoyanMallGoods info;
    List<CskaoyanMallIssue> issue;
    List<CskaoyanMallGoodsProduct> productList;
    String shareImage;
    List<GoodsSpecificationVo> specificationList;
    long userHasCollect;

    public List<CskaoyanMallGoodsAttribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<CskaoyanMallGoodsAttribute> attribute) {
        this.attribute = attribute;
    }

    public CskaoyanMallBrand getBrand() {
        return brand;
    }

    public void setBrand(CskaoyanMallBrand brand) {
        this.brand = brand;
    }

    public GoodsCommentVo getComment() {
        return comment;
    }

    public void setComment(GoodsCommentVo comment) {
        this.comment = comment;
    }

    public CskaoyanMallGoods getInfo() {
        return info;
    }

    public void setInfo(CskaoyanMallGoods info) {
        this.info = info;
    }

    public List<CskaoyanMallIssue> getIssue() {
        return issue;
    }

    public void setIssue(List<CskaoyanMallIssue> issue) {
        this.issue = issue;
    }

    public List<CskaoyanMallGoodsProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<CskaoyanMallGoodsProduct> productList) {
        this.productList = productList;
    }

    public String getShareImage() {
        return shareImage;
    }

    public void setShareImage(String shareImage) {
        this.shareImage = shareImage;
    }

    public List<GoodsSpecificationVo> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<GoodsSpecificationVo> specificationList) {
        this.specificationList = specificationList;
    }

    public List<CskaoyanMallGrouponRules> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<CskaoyanMallGrouponRules> groupon) {
        this.groupon = groupon;
    }

    public long getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(long userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
