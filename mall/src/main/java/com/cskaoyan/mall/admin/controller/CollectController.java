package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.PageBean2;
import com.cskaoyan.mall.admin.service.CollectService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.config.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 微信小程序与收藏相关接口
 * @author Tyj
 * @date 2019/10/4 20:25
 */
@RestController
@RequestMapping("wx/collect")
public class CollectController {
    @Autowired
    CollectService collectService;

    //获得商品收藏列表
    @RequestMapping("list")
    public BaseResponseVo getPageBean(int type,int page,int size){
        PageBean2 pageBean = collectService.getCollectList(type, page, size);
         return  BaseResponseVo.ok(pageBean);
    }

    @RequestMapping("addordelete")
    public BaseResponseVo getPageBean2(int type, int valueId, HttpServletRequest request){
        String header = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(header);
        Map<String, String> map = collectService.addCollectList(type, valueId,userId);
        return  BaseResponseVo.ok(map);
    }
}
