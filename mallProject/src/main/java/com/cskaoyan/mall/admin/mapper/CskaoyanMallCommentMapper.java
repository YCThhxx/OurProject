package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;

public interface CskaoyanMallCommentMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallComment record);

    int updateByPrimaryKey(CskaoyanMallComment record);
}