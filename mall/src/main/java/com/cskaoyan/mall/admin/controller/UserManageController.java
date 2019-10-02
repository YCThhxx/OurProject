package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.UserManageService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tyj
 * @date 2019/10/1 15:59
 */
@RestController
@RequestMapping("admin")
public class UserManageController {

    @Autowired
    UserManageService userManageService;

    //会员管理
    @RequestMapping("/user/list")
    public BaseResponseVo getPageBean1(int page, int limit, String sort, String order, String username, String mobile){
        PageBean pageBean = userManageService.getPageBean1(page, limit, sort, order, username, mobile);
        return BaseResponseVo.ok(pageBean);
    }

    //收货地址
    @RequestMapping("/address/list")
    public BaseResponseVo getPageBean2(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        PageBean pageBean = userManageService.getPageBean2(page, limit, sort, order, userId, name);
        return BaseResponseVo.ok(pageBean);
    }

    //会员收藏
    @RequestMapping("/collect/list")
    public BaseResponseVo getPageBean3(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String userId = request.getParameter("userId");
        String valueId = request.getParameter("valueId");
        PageBean pageBean = userManageService.getPageBean3(page, limit, sort, order, userId, valueId);
        return BaseResponseVo.ok(pageBean);
    }

    //会员足迹
    @RequestMapping("/footprint/list")
    public BaseResponseVo getPageBean4(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String userId = request.getParameter("userId");
        String goodsId = request.getParameter("goodsId");
        PageBean pageBean = userManageService.getPageBean4(page, limit, sort, order, userId, goodsId);
        return BaseResponseVo.ok(pageBean);
    }

    //搜索历史
    @RequestMapping("/history/list")
    public BaseResponseVo getPageBean5(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String userId = request.getParameter("userId");
        String keyWord = request.getParameter("keyword");
        PageBean pageBean = userManageService.getPageBean5(page, limit, sort, order, userId, keyWord);
        return BaseResponseVo.ok(pageBean);
    }

    //意见反馈
    @RequestMapping("/feedback/list")
    public BaseResponseVo getPageBean6(HttpServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        PageBean pageBean = userManageService.getPageBean6(page, limit, sort, order, id, username);
        return BaseResponseVo.ok(pageBean);
    }
}
