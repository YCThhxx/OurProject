package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.CskaoyanMallFeedback;

public interface CskaoyanMallFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    CskaoyanMallFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CskaoyanMallFeedback record);

    int updateByPrimaryKey(CskaoyanMallFeedback record);
}