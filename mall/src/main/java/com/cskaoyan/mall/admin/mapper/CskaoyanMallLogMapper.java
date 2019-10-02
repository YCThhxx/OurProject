package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;
import com.cskaoyan.mall.admin.bean.CskaoyanMallLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallLogMapper {
    long countByExample(CskaoyanMallLogExample example);

    int deleteByExample(CskaoyanMallLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallLog record);

    int insertSelective(CskaoyanMallLog record);

    List<CskaoyanMallLog> selectByExample(CskaoyanMallLogExample example);

    CskaoyanMallLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallLog record, @Param("example") CskaoyanMallLogExample example);

    int updateByExample(@Param("record") CskaoyanMallLog record, @Param("example") CskaoyanMallLogExample example);

    int updateByPrimaryKeySelective(CskaoyanMallLog record);

    int updateByPrimaryKey(CskaoyanMallLog record);

    long countAllLog();

    List<CskaoyanMallLog> queryAllLog(@Param("sort") String sort,
                                      @Param("order") String order);

    List<CskaoyanMallLog> queryAllLogLikeUsername(@Param("sort") String sort,
                                                  @Param("order") String order,
                                                  @Param("username") String username);
}
