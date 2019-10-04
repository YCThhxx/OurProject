package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallTopicMapper;
import com.cskaoyan.mall.admin.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    CskaoyanMallTopicMapper cskaoyanMallTopicMapper;


    @Override
    public PageBean getListOfTopic(int returnPage, int returnPageSize, String title, String subtitle, String sort, String order) {
        String orderBy = sort +" " + order;
        PageHelper.startPage(returnPage, returnPageSize, orderBy);
        List<CskaoyanMallTopic> topicList = cskaoyanMallTopicMapper.selectByPageAndPageSize(title,subtitle);
        PageInfo<CskaoyanMallTopic> adPageInfo = new PageInfo<>(topicList);
        long total = adPageInfo.getTotal();
        PageBean<List> pageListBean = new PageBean<>();
        pageListBean.setItems(topicList);
        pageListBean.setTotal(total);
        return pageListBean;
    }

    @Override
    public void delete(Integer id) {
        cskaoyanMallTopicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CskaoyanMallTopic topic) {
        topic.setUpdateTime(new Date());
        cskaoyanMallTopicMapper.updateByPrimaryKeySelective(topic);
    }

    @Override
    public void create(CskaoyanMallTopic topic) {
        topic.setUpdateTime(new Date());
        topic.setAddTime(new Date());
        cskaoyanMallTopicMapper.insertTopic(topic);
    }
}
