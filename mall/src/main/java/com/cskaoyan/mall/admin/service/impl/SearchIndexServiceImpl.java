package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallKeywordMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallSearchHistoryMapper;
import com.cskaoyan.mall.admin.service.SearchIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyj
 * @date 2019/10/5 15:30
 */
@Service
public class SearchIndexServiceImpl implements SearchIndexService {

    @Autowired
    CskaoyanMallKeywordMapper cskaoyanMallKeywordMapper;
    @Autowired
    CskaoyanMallSearchHistoryMapper cskaoyanMallSearchHistoryMapper;


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

}
