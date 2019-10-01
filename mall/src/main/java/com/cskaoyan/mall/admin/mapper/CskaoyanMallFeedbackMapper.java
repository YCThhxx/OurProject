package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallFeedback;
import com.cskaoyan.mall.admin.bean.CskaoyanMallFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallFeedbackMapper {
    long countByExample(CskaoyanMallFeedbackExample example);

    int deleteByExample(CskaoyanMallFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallFeedback record);

    int insertSelective(CskaoyanMallFeedback record);

    List<CskaoyanMallFeedback> selectByExample(CskaoyanMallFeedbackExample example);

    CskaoyanMallFeedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallFeedback record, @Param("example") CskaoyanMallFeedbackExample example);

    int updateByExample(@Param("record") CskaoyanMallFeedback record, @Param("example") CskaoyanMallFeedbackExample example);

    int updateByPrimaryKeySelective(CskaoyanMallFeedback record);

    int updateByPrimaryKey(CskaoyanMallFeedback record);
}