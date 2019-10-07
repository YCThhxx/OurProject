package com.cskaoyan.mall.admin.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Tyj
 * @date 2019/10/5 17:28
 */
public class CommentList {

    CskaoyanMallUser userInfo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    Date addTime;
    String[] picList;
    String content;

    public CskaoyanMallUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(CskaoyanMallUser userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
