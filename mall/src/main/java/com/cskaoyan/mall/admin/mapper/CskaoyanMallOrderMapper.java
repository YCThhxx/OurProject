package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallOrder;
import com.cskaoyan.mall.admin.bean.CskaoyanMallOrderExample;
import com.cskaoyan.mall.wx.vo.orderVo.OrderListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CskaoyanMallOrderMapper {
    long countByExample(CskaoyanMallOrderExample example);

    int deleteByExample(CskaoyanMallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallOrder record);

    int insertSelective(CskaoyanMallOrder record);

    List<CskaoyanMallOrder> selectByExample(CskaoyanMallOrderExample example);

    CskaoyanMallOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallOrder record, @Param("example") CskaoyanMallOrderExample example);

    int updateByExample(@Param("record") CskaoyanMallOrder record, @Param("example") CskaoyanMallOrderExample example);

    int updateByPrimaryKeySelective(CskaoyanMallOrder record);

    int updateByPrimaryKey(CskaoyanMallOrder record);

    List showOrderByPage(String orderSn, Integer orderStatusArray, Integer userId);

    int selectOrdersTotal();

    List<OrderListVo> queryOrderByUserId(@Param("userId") int userId,
                                         @Param("status") int status);

    int queryOrderAmountByUserId(int userId);

    int insertShin(int orderId, String shipChannel, String shipSn);
}
