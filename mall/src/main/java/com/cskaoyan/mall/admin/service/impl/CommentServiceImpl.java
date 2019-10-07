package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCommentExample;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallCommentMapper;
import com.cskaoyan.mall.admin.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CskaoyanMallCommentMapper cskaoyanMallCommentMapper;

    @Override
    public PageBean getListOfComments(int page, int limit, String sort, String order, String userId, String valueId) {
        String orderBy = sort+" "+order;
        PageHelper.startPage(page,limit,orderBy);
        CskaoyanMallCommentExample commentExample = new CskaoyanMallCommentExample();
        CskaoyanMallCommentExample.Criteria criteria = commentExample.createCriteria();

        if (userId!=null&&userId!=""){
            int uid = Integer.parseInt(userId);
            criteria.andUserIdEqualTo(uid);
        }
        if (valueId!=null&&valueId!="") {
            int vid = Integer.parseInt(valueId);
            criteria.andValueIdEqualTo(vid);
        }

        List<CskaoyanMallComment> cskaoyanMallComments = cskaoyanMallCommentMapper.selectByExample(commentExample);
        PageInfo<CskaoyanMallComment> commentPageInfo = new PageInfo<>(cskaoyanMallComments);
        long total = commentPageInfo.getTotal();
        PageBean<Object> pageBean = new PageBean<>();
        pageBean.setTotal(total);
        pageBean.setItems(cskaoyanMallComments);
        return pageBean;
    }

    @Override
    public boolean deleteCommentById(Integer id) {
        int i = cskaoyanMallCommentMapper.deleteByPrimaryKey(id);
        if (i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean replyComment(Integer commentId, String content) {
        CskaoyanMallComment cskaoyanMallComment = cskaoyanMallCommentMapper.selectByPrimaryKey(commentId);
        String oldcontent = cskaoyanMallComment.getContent();
        if (oldcontent==null||oldcontent==""){
            cskaoyanMallComment.setContent(content);
            return true;
        }else {
            return false;
        }
    }
}
