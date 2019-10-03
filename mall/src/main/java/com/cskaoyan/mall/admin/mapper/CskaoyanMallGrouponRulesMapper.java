package com.cskaoyan.mall.admin.mapper;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

public interface CskaoyanMallGrouponRulesMapper {
    long countByExample(CskaoyanMallGrouponRulesExample example);

    int deleteByExample(CskaoyanMallGrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CskaoyanMallGrouponRules record);

    int insertSelective(CskaoyanMallGrouponRules record);

    List<CskaoyanMallGrouponRules> selectByExample(CskaoyanMallGrouponRulesExample example);

    CskaoyanMallGrouponRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CskaoyanMallGrouponRules record, @Param("example") CskaoyanMallGrouponRulesExample example);

    int updateByExample(@Param("record") CskaoyanMallGrouponRules record, @Param("example") CskaoyanMallGrouponRulesExample example);

    int updateByPrimaryKeySelective(CskaoyanMallGrouponRules record);

    int updateByPrimaryKey(CskaoyanMallGrouponRules record);

    List<CskaoyanMallGrouponRules> selectAllGrouponRulesByAddtime(@Param("by") String addtime,
                                                                  @Param("order") String order,
                                                                  @Param("goodsid") String goodsid);

    long countAllRules();

    void updateRule(@Param("rule") CskaoyanMallGrouponRules cskaoyanMallGrouponRules);

    void deleteById(@Param("id") Integer id);

    void createRule(@Param("rule") CskaoyanMallGrouponRules cskaoyanMallGrouponRules);

}
