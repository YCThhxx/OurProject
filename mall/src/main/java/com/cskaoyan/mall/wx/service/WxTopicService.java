package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import com.cskaoyan.mall.wx.vo.topicvo.TopicDetailVo;
import com.cskaoyan.mall.wx.vo.topicvo.TopicListVo;

import java.util.List;

public interface WxTopicService {
    TopicListVo topicList(int page, int size);

    TopicDetailVo topicDetail(int id);

    List<CskaoyanMallTopic> topicRelated(int id);
}
