package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CskaoyanMallUserService {
    UserOrderVo selectOrderMsg(Integer userId);

    Integer queryUserIdByUserName(@Param("username") String principal);
}
