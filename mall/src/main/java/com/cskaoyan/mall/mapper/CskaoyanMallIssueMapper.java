package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallIssue;

public interface CskaoyanMallIssueMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallIssue record);

    int updateByPrimaryKey(CskaoyanMallIssue record);
}