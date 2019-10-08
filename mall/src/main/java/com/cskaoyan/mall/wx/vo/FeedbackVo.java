package com.cskaoyan.mall.wx.vo;

public class FeedbackVo {

//    content: "不好"
//    feedType: "商品相关"
//    hasPicture: false
//    mobile: "18888888888"
//    picUrls: []
    private String content;
    private String feedType;
    private boolean hasPicture;
    private String mobile;
    private String[] picUrls;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }
}
