package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.SearchIndexResp;
import com.cskaoyan.mall.wx.config.UserTokenManager;
import com.cskaoyan.mall.wx.service.WxSearchIndexService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.WxUserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 微信搜索商品相关接口
 * @author Tyj
 * @date 2019/10/5 15:12
 */
@RequestMapping("wx/search")
@RestController
public class WxSearchController {

    @Autowired
    WxSearchIndexService searchIndexService;
    @Autowired
    WxUserService wxUserService;


    @RequestMapping("index")
    public BaseResponseVo getSearchIndex(){
        SearchIndexResp searchIndex = searchIndexService.getSearchIndex();
        return BaseResponseVo.ok(searchIndex);
    }

    @RequestMapping("helper")
    public BaseResponseVo helper(@Param("keyword") String keyword){
        List<String> keyWordHelper = searchIndexService.getKeyWordHelper(keyword);
        return BaseResponseVo.ok(keyWordHelper);
    }

    @RequestMapping("clearhistory")
    public BaseResponseVo clearSearchHistory(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        searchIndexService.clearSearchHistory(userId);
        return BaseResponseVo.ok();
    }

}
