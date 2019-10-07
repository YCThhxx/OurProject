package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WxUserService {
    UserOrderVo selectOrderMsg(Integer userId);

    Integer queryUserIdByUserName(@Param("username") String principal);


    boolean registerUser(String mobile, String username, String password);

    CskaoyanMallUser selectByUsernameAndPassword(String username, String password);
}
