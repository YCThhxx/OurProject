package com.cskaoyan.mall.wx.service.impl;


import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCommentMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.wx.service.WxCommentService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tyj
 * @date 2019/10/5 17:35
 */
@Service
public class WxCommentServiceImpl implements WxCommentService {
    @Autowired
    CskaoyanMallUserMapper cskaoyanMallUserMapper;
    @Autowired
    CskaoyanMallCommentMapper cskaoyanMallCommentMapper;
    @Autowired
    WxUserService wxUserService;


    //获取商品评论列表
    @Override
    public PageBean3 getCommentList(int valueId, int type, int size, int page, int showType) {
        PageHelper.startPage(page,size);

        List<CommentList> commentLists = new ArrayList<>();
        CskaoyanMallCommentExample mallCommentExample = new CskaoyanMallCommentExample();
        mallCommentExample.createCriteria().andValueIdEqualTo(valueId);
        List<CskaoyanMallComment> mallComments = cskaoyanMallCommentMapper.selectByExample(mallCommentExample);
        long total = new PageInfo<>(mallComments).getTotal();
        for (CskaoyanMallComment mallComment : mallComments) {
            Date addTime = mallComment.getAddTime();
            String[] picUrls = mallComment.getPicUrls();
            String content = mallComment.getContent();
            CommentList commentList = new CommentList();
            commentList.setAddTime(addTime);
            commentList.setContent(content);
            commentList.setPicList(picUrls);
            Integer userId = mallComment.getUserId();
            CskaoyanMallUser cskaoyanMallUser = cskaoyanMallUserMapper.selectByPrimaryKey(userId);
            commentList.setUserInfo(cskaoyanMallUser);
            commentLists.add(commentList);
        }
        PageBean3<Object> pageBean3 = new PageBean3<>();
        pageBean3.setCurrentPage(page);
        pageBean3.setData(commentLists);
        pageBean3.setCount((int)total);
        return pageBean3;
    }

    //获得商品评论总数
    @Override
    public CommentCount getCommentCount(int valueId, int type) {
        CskaoyanMallCommentExample mallCommentExample = new CskaoyanMallCommentExample();
        int totalCount = cskaoyanMallCommentMapper.selectCommentCount(valueId);
        int picCount = cskaoyanMallCommentMapper.selectHasPicCount(valueId);
        CommentCount commentCount = new CommentCount();
        commentCount.setAllCount(totalCount);
        commentCount.setHasPicCount(picCount);
        return commentCount;
    }

    //发表评论
    @Override
    public CskaoyanMallComment postComment(CskaoyanMallComment cskaoyanMallComment) {
       /* String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);*/
        Date date = new Date();
        cskaoyanMallComment.setAddTime(date);
        cskaoyanMallComment.setUpdateTime(date);
        /*cskaoyanMallComment.setUserId(userId);*/
        String[] picUrls = cskaoyanMallComment.getPicUrls();
        if(picUrls!=null){
            cskaoyanMallComment.setHasPicture(true);
        }
        int i = cskaoyanMallCommentMapper.insert(cskaoyanMallComment);
        /*cskaoyanMallComment.setId(id);*/
        return cskaoyanMallComment;
    }
}
