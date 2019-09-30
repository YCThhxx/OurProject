package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFeedback;

public interface CskaoyanMallFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallFeedback record);

    int updateByPrimaryKey(CskaoyanMallFeedback record);
}