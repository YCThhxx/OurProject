package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;
import com.cskaoyan.mall.admin.bean.PageBean;

public interface KeyWordService {

    PageBean showKeyByPage(int page, int limit, String sort, String order);

    CskaoyanMallKeyword addKeyWord(CskaoyanMallKeyword cskaoyanMallKeyword);

    CskaoyanMallKeyword updateKeyWord(CskaoyanMallKeyword cskaoyanMallKeyword);
}
