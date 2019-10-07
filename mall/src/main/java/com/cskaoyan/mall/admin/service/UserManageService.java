package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.bean.PageBean;

/**
 * @author Tyj
 * @date 2019/10/1 16:08
 */
public interface UserManageService {
    PageBean getPageBean1(int page, int limit, String sort, String order, String username, String mobile);

    PageBean getPageBean2(String page, String limit, String sort, String order, String userId, String name);
    PageBean getPageBean3(String page, String limit, String sort, String order, String userId, String valueId);

    PageBean getPageBean4(String page, String limit, String sort, String order, String userId, String goodsId);

    PageBean getPageBean5(String page, String limit, String sort, String order, String userId, String keyWord);

    PageBean getPageBean6(String page, String limit, String sort, String order, String id, String username);

    int selectByUsername(String username);
}
