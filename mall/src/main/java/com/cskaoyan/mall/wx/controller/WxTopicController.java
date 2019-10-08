package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallTopic;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.WxTopicService;
import com.cskaoyan.mall.wx.vo.topicvo.TopicDetailVo;
import com.cskaoyan.mall.wx.vo.topicvo.TopicListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/topic")
public class WxTopicController {

    @Autowired
    WxTopicService topicService;
    @RequestMapping("list")
    public BaseResponseVo topicList(int page,int size){
        TopicListVo topicListVo = topicService.topicList(page,size);
        return BaseResponseVo.ok(topicListVo);
    }

    @RequestMapping("detail")
    public BaseResponseVo topicDetail(int id){
        TopicDetailVo topicDetailVo = topicService.topicDetail(id);
        return BaseResponseVo.ok(topicDetailVo);
    }

    @RequestMapping("related")
    public BaseResponseVo topicRelated(int id){
        List<CskaoyanMallTopic> topics = topicService.topicRelated(id);
        return BaseResponseVo.ok(topics);
    }
}
