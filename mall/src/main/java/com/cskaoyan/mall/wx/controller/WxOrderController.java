package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.vo.OrderDetail;
import com.cskaoyan.mall.wx.service.WxOrderService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import com.cskaoyan.mall.wx.vo.orderVo.OrderDetailVo;
import com.cskaoyan.mall.wx.vo.orderVo.OrderTotalVo;
import com.cskaoyan.mall.wx.vo.orderVo.OrderListVo;
import com.cskaoyan.mall.wx.vo.orderVo.SubmitRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/order/")
public class WxOrderController {

    @Autowired
    WxUserService userService;

    Subject subject;

    @Autowired
    WxOrderService orderService;

    @GetMapping("list")
    public BaseRespVo list(Integer showType, Integer page, int size){
        subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        Integer userId = userService.queryUserIdByUserName(principal);
        if (showType == null){
            showType = 0;
        }
        List<OrderListVo> orderlist = orderService.getOrderListByUserId(userId, showType, page, size);
        int count = orderService.getOrderAmountByUserId(userId);
        OrderTotalVo orderTotalVo = new OrderTotalVo(orderlist, count);
        BaseRespVo baseRespVo = BaseRespVo.ok(orderTotalVo);
        return baseRespVo;
    }

    @GetMapping("detail")
    public BaseRespVo detail(int orderId){
        OrderDetailVo orderDetail = orderService.getOrderDetailByOrderId(orderId);
        BaseRespVo baseRespVo = BaseRespVo.ok(orderDetail);
        return baseRespVo;
    }



    @PostMapping("submit")
    public BaseRespVo submit(@RequestBody SubmitRequest submitRequest){
        subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        Integer userId = userService.queryUserIdByUserName(principal);
        Map<String, Integer> resultMap = new HashMap<>();
        int orderId = orderService.submit(userId, submitRequest);
        resultMap.put("orderId", orderId);
        return BaseRespVo.ok(resultMap);
    }

    @PostMapping("cancel")
    public BaseRespVo cancel(@RequestBody Map<String, Integer> map){
        int orderId = map.get("orderId");
        System.out.println(orderId);
        orderService.cancelOrder(orderId);
        return BaseRespVo.ok(0);
    }

    @PostMapping("delete")
    public BaseRespVo delete(@RequestBody Map<String, Integer> map){
        int orderId = map.get("orderId");
        System.out.println(orderId);
        orderService.cancelOrder(orderId);
        return BaseRespVo.ok(0);
    }

    @PostMapping("confirm")
    public BaseRespVo confirm(@RequestBody Map<String, Integer> map){
        int orderId = map.get("orderId");
        System.out.println(orderId);
        orderService.confirmOrder(orderId);
        return BaseRespVo.ok(0);
    }

    @PostMapping("prepay")
    public BaseRespVo prepay(@RequestBody Map<String, Integer> map){
        int orderId = map.get("orderId");
        orderService.prepayOrder(orderId);
        return BaseRespVo.orderFail();
    }
}
