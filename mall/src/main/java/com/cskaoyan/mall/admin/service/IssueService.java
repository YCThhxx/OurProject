package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;
import com.cskaoyan.mall.admin.bean.PageBean;

public interface IssueService {
    PageBean showIssueByPage(int page, int limit, String sort, String order, String question);

    CskaoyanMallIssue addIssue(CskaoyanMallIssue cskaoyanMallIssue);

     CskaoyanMallIssue updateIssue(CskaoyanMallIssue cskaoyanMallIssue);

    boolean deleteIssue(CskaoyanMallIssue cskaoyanMallIssue);
}
