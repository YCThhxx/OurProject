package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallCart;
import com.cskaoyan.mall.admin.bean.CskaoyanMallCartExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallCartMapper {
    long countByExample(CskaoyanMallCartExample example);

    int deleteByExample(CskaoyanMallCartExample example);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(CskaoyanMallCart record);

    int insertSelective(CskaoyanMallCart record);

    List<CskaoyanMallCart> selectByExample(CskaoyanMallCartExample example);

    CskaoyanMallCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallCart record, @Param("example") CskaoyanMallCartExample example);

    int updateByExample(@Param("record") CskaoyanMallCart record, @Param("example") CskaoyanMallCartExample example);

    int updateByPrimaryKeySelective(CskaoyanMallCart record);

    int updateByPrimaryKey(CskaoyanMallCart record);

    int queryUserIdByUsername(String principal);

    List<CskaoyanMallCart> quertCartByUserId(@Param("id") int userId);


    void update(@Param("id") int productId,@Param("number") int number,@Param("userid") int userId);

    void updateCheck(@Param("isChecked") int i,@Param("userId") int userId,@Param("productId") int productId);

    int queryGoodsSum(int userId);

    int queryCartIdByDateAndUserId(@Param("userId") int userId,@Param("date") Date date);


    List<CskaoyanMallCart> selectByUserId(Integer userId);

    List<CskaoyanMallCart> selectByUserIdAndChecked(int userId);

    void deleteByUserIdAndChecked(int userId);

}
