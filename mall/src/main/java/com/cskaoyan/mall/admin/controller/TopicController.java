package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAd;
import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.TopicService;
import com.cskaoyan.mall.admin.utils.PagingUtil;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/topic")
public class TopicController {
    @Autowired
    TopicService topicService;
    @RequestMapping("list")
    public BaseResponseVo list(String page,String limit,String title,String subtitle,String sort,String order){
        PageBean list = topicService.getListOfTopic(PagingUtil.returnPage(page), PagingUtil.returnPageSize(limit), title, subtitle,sort,order);
        BaseResponseVo ok = BaseResponseVo.ok(list);
        return ok;
    }
    @RequestMapping("delete")
    public BaseResponseVo delete(@RequestBody CskaoyanMallTopic topic){
        topicService.delete(topic.getId());
        BaseResponseVo ok = BaseResponseVo.ok(null);
        return  ok;
    }
    @RequestMapping("update")
    public BaseResponseVo update(@RequestBody CskaoyanMallTopic topic){
        topicService.update(topic);
        BaseResponseVo ok = BaseResponseVo.ok(topic);
        return  ok;
    }
    @RequestMapping("create")
    public BaseResponseVo create(@RequestBody CskaoyanMallTopic topic){
        topicService.create(topic);
        BaseResponseVo ok = BaseResponseVo.ok(topic);
        return  ok;
    }
}
