package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallTopicMapper;
import com.cskaoyan.mall.wx.service.WxTopicService;
import com.cskaoyan.mall.wx.vo.topicvo.TopicDetailVo;
import com.cskaoyan.mall.wx.vo.topicvo.TopicListVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxTopicServiceImpl implements WxTopicService {

    @Autowired
    CskaoyanMallTopicMapper mallTopicMapper;

    @Override
    public TopicListVo topicList(int page, int size) {
        PageHelper.startPage(page,size);
        List<CskaoyanMallTopic> topics = mallTopicMapper.selectAll();
        PageInfo pageInfo = new PageInfo(topics);
        TopicListVo topicListVo = new TopicListVo();
        topicListVo.setData(topics);
        topicListVo.setCount((int) pageInfo.getTotal());
        return topicListVo;
    }

    @Override
    public TopicDetailVo topicDetail(int id) {
        TopicDetailVo topicDetailVo = new TopicDetailVo();
        CskaoyanMallTopic topic = mallTopicMapper.selectByPrimaryKey(id);
        List goods = new ArrayList();
        String[] good = topic.getGoods();
        for (String s : good) {
            goods.add(s);
        }
        topicDetailVo.setGoods(goods);
        topicDetailVo.setTopic(topic);
        return topicDetailVo;
    }

    @Override
    public List<CskaoyanMallTopic> topicRelated(int id) {
        PageHelper.startPage(1,4);
        List<CskaoyanMallTopic> topics = mallTopicMapper.selectRelated(id);
        return topics;
    }
}
