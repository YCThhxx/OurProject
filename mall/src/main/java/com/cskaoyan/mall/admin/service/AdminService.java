package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.vo.UserInfo;

public interface AdminService {
    UserInfo queryAdminInfo(String username);

}
