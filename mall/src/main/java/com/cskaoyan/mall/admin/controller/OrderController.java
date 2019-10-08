package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.CommentService;
import com.cskaoyan.mall.admin.service.OrderService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.OrderDetail;
import com.cskaoyan.mall.admin.vo.statvo.CommentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CommentService commentService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponseVo viewOrder(@Param("page") int page, @Param("limit") int limit,
                                      @Param("sort") String sort, @Param("order") String order,
                                      @Param("orderStatusArray") Integer  orderStatusArray, @Param("orderSn") String orderSn,
                                      @Param("userId") Integer userId){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        PageBean data = orderService.showOrderByPage(page, limit, sort, order, orderStatusArray, orderSn, userId);
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public BaseResponseVo getOrderDetail(@Param("id") int id){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        OrderDetail data = orderService.getOrderDetail(id);
        result.setData(data);
        return result;
    }

    @RequestMapping("reply")
    public BaseResponseVo replyComment(@RequestBody CommentInfo commentInfo){
        Integer commentId = commentInfo.getCommentId();
        String content = commentInfo.getContent();
        boolean flag = commentService.replyComment(commentId,content);
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (flag){
            baseResponseVo.setErrno(0);
            baseResponseVo.setErrmsg("成功");
        }else {
            baseResponseVo.setErrmsg("订单商品已回复！");
            baseResponseVo.setErrno(5000);
        }
        return baseResponseVo;
    }

    @PostMapping("ship")
    public BaseResponseVo ship(@Param("orderId") Integer orderId,
                               @Param("shipChannel") String shipChannel,
                               @Param("shipSn") String shipSn){
//        orderService.insertShip(orderId,shipChannel,shipSn);

      return BaseResponseVo.ok();
    }
}
