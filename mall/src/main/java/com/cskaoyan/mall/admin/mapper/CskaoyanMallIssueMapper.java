package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.bean.CskaoyanMallIssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;

import java.util.List;

public interface CskaoyanMallIssueMapper {
    long countByExample(CskaoyanMallIssueExample example);

    int deleteByExample(CskaoyanMallIssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallIssue record);

    int insertSelective(CskaoyanMallIssue record);

    List<CskaoyanMallIssue> selectByExample(CskaoyanMallIssueExample example);

    CskaoyanMallIssue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallIssue record, @Param("example") CskaoyanMallIssueExample example);

    int updateByExample(@Param("record") CskaoyanMallIssue record, @Param("example") CskaoyanMallIssueExample example);

    int updateByPrimaryKeySelective(CskaoyanMallIssue record);

    int updateByPrimaryKey(CskaoyanMallIssue record);

    List<CskaoyanMallIssue> showIssueByPage(String question);

    int addIssue(CskaoyanMallIssue record);
}