package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;

public interface CskaoyanMallUserService {
    UserOrderVo selectOrderMsg(Integer userId);

    boolean registerUser(String mobile, String username, String password);

}
