package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.SearchIndexResp;
import com.cskaoyan.mall.admin.service.SearchIndexService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信搜索商品相关接口
 * @author Tyj
 * @date 2019/10/5 15:12
 */
@RequestMapping("wx/search")
@RestController
public class SearchController {

    @Autowired
    SearchIndexService searchIndexService;


    @RequestMapping("index")
    public BaseResponseVo getSearchIndex(){
        SearchIndexResp searchIndex = searchIndexService.getSearchIndex();
        return BaseResponseVo.ok(searchIndex);
    }

    @RequestMapping("helper")
    public BaseResponseVo helper(){

    }

}
