package com.cskaoyan.mall.admin.bean;

import java.util.List;

/**
 * @author Tyj
 * @date 2019/10/5 15:21
 */
public class SearchIndexResp {
    CskaoyanMallKeyword defaultKeyword;
    List<CskaoyanMallKeyword> hotKeywordList;

    List<CskaoyanMallSearchHistory> historyKeywordList;

    public CskaoyanMallKeyword getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(CskaoyanMallKeyword defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<CskaoyanMallKeyword> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<CskaoyanMallKeyword> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }

    public List<CskaoyanMallSearchHistory> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<CskaoyanMallSearchHistory> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }
}
