package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.PageBean;

public interface CommentService {
    PageBean getListOfComments(int page, int limit, String sort, String order, String userId, String valueId);

    boolean deleteCommentById(Integer id);

    boolean replyComment(Integer commentId, String content);
}
