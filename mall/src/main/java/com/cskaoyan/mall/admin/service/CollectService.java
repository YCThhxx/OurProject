package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallGoods;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.bean.PageBean2;

import java.util.List;
import java.util.Map;

/**
 * @author Tyj
 * @date 2019/10/4 20:29
 */
public interface CollectService {
   PageBean2 getCollectList(int type, int page, int size);
   Map<String,String> addCollectList(int type,int valueId,Integer userId);
}
