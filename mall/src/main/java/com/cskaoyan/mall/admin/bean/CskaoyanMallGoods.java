package com.cskaoyan.mall.admin.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class CskaoyanMallGoods {
    private Integer id;

    private String goods_sn;

    private String name;

    private Integer category_id;

    private Integer brand_id;

    private String[] gallery;

    private String keywords;

    private String brief;

    private Boolean isOnSale;

    private Short sort_order;

    private String pic_url;

    private String shareUrl;

    private Boolean is_new;

    private Boolean is_hot;

    private String unit;

    private BigDecimal counter_price;

    private BigDecimal retail_price;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date add_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    private Boolean deleted;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goods_sn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goods_sn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategoryId() {
        return category_id;
    }

    public void setCategoryId(Integer categoryId) {
        this.category_id = categoryId;
    }

    public Integer getBrandId() {
        return brand_id;
    }

    public void setBrandId(Integer brandId) {
        this.brand_id = brandId;
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Short getSortOrder() {
        return sort_order;
    }

    public void setSortOrder(Short sortOrder) {
        this.sort_order = sortOrder;
    }

    public String getPicUrl() {
        return pic_url;
    }

    public void setPicUrl(String picUrl) {
        this.pic_url = picUrl == null ? null : picUrl.trim();
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl == null ? null : shareUrl.trim();
    }

    public Boolean getIsNew() {
        return is_new;
    }

    public void setIsNew(Boolean isNew) {
        this.is_new = isNew;
    }

    public Boolean getIsHot() {
        return is_hot;
    }

    public void setIsHot(Boolean isHot) {
        this.is_hot = isHot;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getCounterPrice() {
        return counter_price;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counter_price = counterPrice;
    }

    public BigDecimal getRetailPrice() {
        return retail_price;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retail_price = retailPrice;
    }

    public Date getAddTime() {
        return add_time;
    }

    public void setAddTime(Date addTime) {
        this.add_time = addTime;
    }

    public Date getUpdateTime() {
        return update_time;
    }

    public void setUpdateTime(Date updateTime) {
        this.update_time = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}
