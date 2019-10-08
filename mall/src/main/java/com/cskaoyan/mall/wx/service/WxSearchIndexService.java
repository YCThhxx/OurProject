package com.cskaoyan.mall.wx.service;


import com.cskaoyan.mall.admin.bean.PageBean3;
import com.cskaoyan.mall.admin.bean.SearchIndexResp;

import java.util.List;


/**
 * @author Tyj
 * @date 2019/10/5 15:29
 */
public interface WxSearchIndexService {
    SearchIndexResp getSearchIndex();
    void clearSearchHistory(Integer userId);
    List<String> getKeyWordHelper(String keyword);
}
