package com.cskaoyan.mall.wx.vo.topicvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;

import java.util.List;

public class TopicListVo {

    List<CskaoyanMallTopic> data;
    int count;

    public List<CskaoyanMallTopic> getData() {
        return data;
    }

    public void setData(List<CskaoyanMallTopic> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
