package com.cskaoyan.mall.wx.vo.topicvo;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;

import java.util.ArrayList;
import java.util.List;

public class TopicDetailVo {

    CskaoyanMallTopic topic;
    List goods;

    public List getGoods() {
        return goods;
    }

    public void setGoods(List goods) {
        this.goods = goods;
    }

    public CskaoyanMallTopic getTopic() {
        return topic;
    }

    public void setTopic(CskaoyanMallTopic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "TopicDetailVo{" +
                "goods=" + goods +
                ", topic=" + topic +
                '}';
    }
}
