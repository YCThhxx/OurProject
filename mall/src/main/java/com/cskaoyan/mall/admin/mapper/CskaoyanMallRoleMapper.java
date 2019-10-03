package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRole;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRoleExample;

import java.util.Date;
import java.util.List;

import com.cskaoyan.mall.admin.vo.OptionVo;
import org.apache.ibatis.annotations.Param;

public interface CskaoyanMallRoleMapper {
    long countByExample(CskaoyanMallRoleExample example);

    int deleteByExample(CskaoyanMallRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallRole record);

    int insertSelective(CskaoyanMallRole record);

    List<CskaoyanMallRole> selectByExample(CskaoyanMallRoleExample example);

    CskaoyanMallRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallRole record, @Param("example") CskaoyanMallRoleExample example);

    int updateByExample(@Param("record") CskaoyanMallRole record, @Param("example") CskaoyanMallRoleExample example);

    int updateByPrimaryKeySelective(CskaoyanMallRole record);

    int updateByPrimaryKey(CskaoyanMallRole record);

    long countAllRole();

    List<CskaoyanMallRole> queryAllRoleLikeUsername(@Param("sort") String sort,
                                                    @Param("order") String order,
                                                    @Param("name") String name);

    CskaoyanMallRole queryRoleById(Integer id);

    void delete(Integer id);
}
