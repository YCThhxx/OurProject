package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.bean.CskaoyanMallAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallAddressMapper {
    long countByExample(CskaoyanMallAddressExample example);

    int deleteByExample(CskaoyanMallAddressExample example);

    int deleteByPrimaryKey(int id);

    int insert(CskaoyanMallAddress record);

    int insertSelective(CskaoyanMallAddress record);

    List<CskaoyanMallAddress> selectByExample(CskaoyanMallAddressExample example);

    CskaoyanMallAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallAddress record, @Param("example") CskaoyanMallAddressExample example);

    int updateByExample(@Param("record") CskaoyanMallAddress record, @Param("example") CskaoyanMallAddressExample example);

    int updateByPrimaryKeySelective(CskaoyanMallAddress record);

    int updateByPrimaryKey(CskaoyanMallAddress record);

    List<CskaoyanMallAddress> selectByUserId(@Param("userId") int userId);

    int saveAddress(CskaoyanMallAddress address);

}