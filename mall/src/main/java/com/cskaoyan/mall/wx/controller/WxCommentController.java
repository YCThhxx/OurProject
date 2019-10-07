package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CommentCount;
import com.cskaoyan.mall.admin.bean.PageBean3;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.WxCommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**微信小程序与评论有关接口
 * @author Tyj
 * @date 2019/10/5 17:25
 */
@RequestMapping("wx/comment")
@RestController
public class WxCommentController {

    @Autowired
    WxCommentService commentService;

    //评论列表
    @RequestMapping("list")
    public BaseResponseVo getCommentList(@Param("valueId") int valueId,
                                         @Param("type") int type,
                                         @Param("size") int size,
                                         @Param("page") int page,
                                         @Param("showType") int showType
                                         ){
        PageBean3 pageBean3 = commentService.getCommentList(valueId,type,size,page,showType);
        return BaseResponseVo.ok(pageBean3);
    }


    //评论总数
    @RequestMapping("count")
    public BaseResponseVo getCommentCount(int valueId,int type){
        CommentCount commentCount = commentService.getCommentCount(valueId, type);
        return BaseResponseVo.ok(commentCount);
    }

    //发表评论
   /* @RequestMapping("post")
    public BaseResponseVo*/
}
