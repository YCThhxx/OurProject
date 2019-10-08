package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.CskaoyanMallFeedback;
import com.cskaoyan.mall.admin.bean.CskaoyanMallFeedbackExample;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallFeedbackMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import com.cskaoyan.mall.wx.vo.FeedbackVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("wx/feedback")
public class FeedbackController {

    @Autowired
    CskaoyanMallFeedbackMapper feedbackMapper;

    @Autowired
    CskaoyanMallUserMapper userMapper;

    @RequestMapping("submit")
    public BaseRespVo submit(@RequestBody FeedbackVo feedbackVo){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        Integer uid = userMapper.selectIdByUsername(principal);
        String[] picUrls = feedbackVo.getPicUrls();
        String content = feedbackVo.getContent();
        String feedType = feedbackVo.getFeedType();
        String mobile = feedbackVo.getMobile();
        boolean hasPicture = feedbackVo.isHasPicture();
        CskaoyanMallFeedback feedback = new CskaoyanMallFeedback();
        feedback.setUserId(uid);
        feedback.setUsername(principal);
        feedback.setHasPicture(hasPicture);
        feedback.setPicUrls(picUrls.toString());
        feedback.setContent(content);
        feedback.setFeedType(feedType);
        feedback.setMobile(mobile);
        feedback.setAddTime(new Date());
        int i = feedbackMapper.insertSelective(feedback);
        if (i==1){
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail(500,"添加失败");
    }
}
