package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;

public interface CskaoyanMallIssueMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallIssue record);

    int updateByPrimaryKey(CskaoyanMallIssue record);
}