package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallComment;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCommentExample;
import java.util.List;

import com.cskaoyan.mall.wx.vo.goodsvo.GoodsCommentVo;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallCommentMapper {
    long countByExample(CskaoyanMallCommentExample example);

    int deleteByExample(CskaoyanMallCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallComment record);

    int insertSelective(CskaoyanMallComment record);

    List<CskaoyanMallComment> selectByExample(CskaoyanMallCommentExample example);

    CskaoyanMallComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallComment record, @Param("example") CskaoyanMallCommentExample example);

    int updateByExample(@Param("record") CskaoyanMallComment record, @Param("example") CskaoyanMallCommentExample example);

    int updateByPrimaryKeySelective(CskaoyanMallComment record);

    int updateByPrimaryKey(CskaoyanMallComment record);


    int selectHasPicCount(@Param("valueId") int valueId);

    int selectCommentCount(@Param("valueId") int valueId);

    List<CskaoyanMallComment> selectByValueId(int id);
}

