package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CommentCount;
import com.cskaoyan.mall.admin.bean.CommentList;
import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;
import com.cskaoyan.mall.admin.bean.PageBean3;

import java.util.List;

/**
 * @author Tyj
 * @date 2019/10/5 17:39
 */
public interface WxCommentService {
    PageBean3 getCommentList(int valueId, int type, int size, int page, int showType);
    CommentCount getCommentCount(int valueId,int type);
    CskaoyanMallComment postComment(CskaoyanMallComment cskaoyanMallComment);
}
