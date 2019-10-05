package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import com.cskaoyan.mall.admin.bean.PageBean;

public interface TopicService {

    PageBean getListOfTopic(int returnPage, int returnPageSize, String title, String subtitle, String sort, String order);

    void delete(Integer id);

    void update(CskaoyanMallTopic topic);

    void create(CskaoyanMallTopic topic);
}
