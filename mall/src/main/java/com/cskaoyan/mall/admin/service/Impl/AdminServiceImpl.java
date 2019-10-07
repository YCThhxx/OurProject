package com.cskaoyan.mall.admin.service.Impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallAdminMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallPermissionMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallRoleMapper;
import com.cskaoyan.mall.admin.service.AdminService;
import com.cskaoyan.mall.admin.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    CskaoyanMallAdminMapper cskaoyanMallAdminMapper;

    @Autowired
    CskaoyanMallRoleMapper cskaoyanMallRoleMapper;

    @Autowired
    CskaoyanMallPermissionMapper cskaoyanMallPermissionMapper;

    @Override
    public UserInfo queryAdminInfo(String username) {
        UserInfo userInfo = new UserInfo();
        CskaoyanMallAdmin cskaoyanMallAdmin =  cskaoyanMallAdminMapper.queryAdminByUsername(username);
        userInfo.setAvatar(cskaoyanMallAdmin.getAvatar());
        userInfo.setName(username);
        long[] roleIds = cskaoyanMallAdmin.getRoleIds();
        for (long id : roleIds) {
            List<String> roles = cskaoyanMallRoleMapper.queryAdminRole((int) id);
            userInfo.setRoles(roles);
            List<String> permissions = cskaoyanMallPermissionMapper.queryPermissions((int) id);
            userInfo.setPerms(permissions);
        }
        return userInfo;
    }
}
