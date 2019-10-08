package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallKeywordMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallSearchHistoryMapper;
import com.cskaoyan.mall.wx.service.WxSearchIndexService;
import com.cskaoyan.mall.wx.service.WxUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tyj
 * @date 2019/10/5 15:30
 */
@Service
public class WxSearchIndexServiceImpl implements WxSearchIndexService {

    @Autowired
    CskaoyanMallKeywordMapper cskaoyanMallKeywordMapper;
    @Autowired
    CskaoyanMallSearchHistoryMapper cskaoyanMallSearchHistoryMapper;
    @Autowired
    WxUserService wxUserService;


    //商品搜索栏详情
    @Override
    public SearchIndexResp getSearchIndex() {
        SearchIndexResp searchIndexResp = new SearchIndexResp();
        //找historyKeywordList
        CskaoyanMallSearchHistoryExample searchHistoryExample = new CskaoyanMallSearchHistoryExample();
        List<CskaoyanMallSearchHistory> cskaoyanMallSearchHistories = cskaoyanMallSearchHistoryMapper.selectByExample(searchHistoryExample);
        searchIndexResp.setHistoryKeywordList(cskaoyanMallSearchHistories);


        //找defaultKeyword
        CskaoyanMallKeywordExample cskaoyanMallKeywordExample = new CskaoyanMallKeywordExample();
        CskaoyanMallKeywordExample.Criteria criteria = cskaoyanMallKeywordExample.createCriteria();
        criteria.andIsDefaultEqualTo(true);
        List<CskaoyanMallKeyword> cskaoyanMallKeywords = cskaoyanMallKeywordMapper.selectByExample(cskaoyanMallKeywordExample);
        searchIndexResp.setDefaultKeyword(cskaoyanMallKeywords.get(0));


        //找hotKeywordList
        CskaoyanMallKeywordExample cskaoyanMallKeywordExample1 = new CskaoyanMallKeywordExample();
        CskaoyanMallKeywordExample.Criteria criteria1 = cskaoyanMallKeywordExample1.createCriteria();
        criteria1.andIsHotEqualTo(true);
        List<CskaoyanMallKeyword> cskaoyanMallKeywords1 = cskaoyanMallKeywordMapper.selectByExample(cskaoyanMallKeywordExample1);
        searchIndexResp.setHotKeywordList(cskaoyanMallKeywords1);

        return searchIndexResp;

    }

    //搜索帮助
    @Override
    public List<String> getKeyWordHelper(String keyword) {
        CskaoyanMallKeywordExample keywordExample = new CskaoyanMallKeywordExample();
        CskaoyanMallKeywordExample.Criteria criteria = keywordExample.createCriteria();
        criteria.andKeywordLike("%"+keyword+ "%");
        List<CskaoyanMallKeyword> keywords = cskaoyanMallKeywordMapper.selectByExample(keywordExample);
        ArrayList<String> strings = new ArrayList<>();
        for (CskaoyanMallKeyword cskaoyanMallKeyword : keywords) {
            String keyword1 = cskaoyanMallKeyword.getKeyword();
            strings.add(keyword1);
        }
        return strings;
    }

    //清楚搜索历史
    @Override
    public void clearSearchHistory(Integer userId) {
        CskaoyanMallSearchHistoryExample searchHistoryExample = new CskaoyanMallSearchHistoryExample();
        CskaoyanMallSearchHistoryExample.Criteria criteria = searchHistoryExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        cskaoyanMallSearchHistoryMapper.deleteByExample(searchHistoryExample);
    }

    //添加搜索历史
    @Override
    public void addSearchHistory(String keyword) {
        Date date = new Date();
        CskaoyanMallKeyword cskaoyanMallKeyword = new CskaoyanMallKeyword();
        CskaoyanMallSearchHistory searchHistory = new CskaoyanMallSearchHistory();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        searchHistory.setUserId(userId);
        searchHistory.setAddTime(date);
        searchHistory.setUpdateTime(date);
        searchHistory.setKeyword(keyword);
        searchHistory.setFrom("wx");
        cskaoyanMallSearchHistoryMapper.insert(searchHistory);
    }
}
