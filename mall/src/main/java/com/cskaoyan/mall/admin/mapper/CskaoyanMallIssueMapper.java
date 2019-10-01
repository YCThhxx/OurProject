package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;

import java.util.List;

public interface CskaoyanMallIssueMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallIssue record);

    int updateByPrimaryKey(CskaoyanMallIssue record);

    List<CskaoyanMallIssue> showIssueByPage(String question);

    int addIssue(CskaoyanMallIssue record);
}