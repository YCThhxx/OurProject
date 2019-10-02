package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.CskaoyanMallGrouponRules;
import com.cskaoyan.mall.admin.vo.ItemsVo;
import com.cskaoyan.mall.admin.vo.grouponvo.GrouponVo;

import java.util.List;

public interface GpService {

    public List<CskaoyanMallGrouponRules> list(int page, int limit, String sort, String order);

    public long countAllRules();

    public long countAllGroupons();

    void updateRule(CskaoyanMallGoods goods, CskaoyanMallGrouponRules cskaoyanMallGrouponRules);

    void delete(Integer id);

    List<CskaoyanMallGrouponRules> listsearch(int page, int limit, String goodsId, String id, String asc);

    void createRule(CskaoyanMallGoods goods, CskaoyanMallGrouponRules cskaoyanMallGrouponRules);

    ItemsVo listRecordSearch(int page, int limit, String goodsId, String sort, String order);
}
