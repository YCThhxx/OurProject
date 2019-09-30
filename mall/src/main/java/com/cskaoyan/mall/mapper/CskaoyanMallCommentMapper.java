package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallComment;

public interface CskaoyanMallCommentMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallComment record);

    int updateByPrimaryKey(CskaoyanMallComment record);
}