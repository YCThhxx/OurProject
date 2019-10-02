package com.cskaoyan.mall.admin.controller;


import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.CommentService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("list")
    public BaseResponseVo listOfComments(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String uId = request.getParameter("userId");
        String vId = request.getParameter("valueId");
        page = page == null || page.trim().length() == 0 ? "1":page;
        limit = limit == null || limit.trim().length() == 0 ? "20":limit;

        int pagei = Integer.parseInt(page);
        int limiti = Integer.parseInt(limit);
        PageBean listOfComments = commentService.getListOfComments(pagei,limiti,sort,order,uId,vId);
        BaseResponseVo ok = BaseResponseVo.ok(listOfComments);
        return ok;
    }

    @RequestMapping("delete")
    public BaseResponseVo deleteComments(@RequestBody CskaoyanMallComment cskaoyanMallComment){
        Integer id = cskaoyanMallComment.getId();
        boolean flag = commentService.deleteCommentById(id);
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (flag){
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }else {
            baseResponseVo.setErrmsg("删除失败");
            baseResponseVo.setErrno(5000);
        }
        return baseResponseVo;
    }

}
