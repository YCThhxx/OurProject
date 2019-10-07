package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.GetJsonBean;
import com.cskaoyan.mall.admin.bean.PageBean2;
import com.cskaoyan.mall.admin.service.CollectService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.config.UserTokenManager;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.util.util.GetJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 微信小程序与收藏相关接口
 * @author Tyj
 * @date 2019/10/4 20:25
 */
@RestController
@RequestMapping("wx/collect")
public class WxCollectController {
    @Autowired
    CollectService collectService;
    @Autowired
    WxUserService wxUserService;

    //获得商品收藏列表
    @RequestMapping("list")
    public BaseResponseVo getPageBean(int type,int page,int size){
        PageBean2 pageBean = collectService.getCollectList(type, page, size);
         return  BaseResponseVo.ok(pageBean);
    }


    //添加收藏或者取消收藏
    @RequestMapping(value = "addordelete",method = RequestMethod.POST)
    public BaseResponseVo getPageBean2(@RequestBody GetJsonBean jsonBean, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        Integer type = jsonBean.getType();
        Integer valueId = jsonBean.getValueId();
        Map<String, String> map = collectService.addCollectList(type, valueId, userId);
        return BaseResponseVo.ok(map);

    }
}
