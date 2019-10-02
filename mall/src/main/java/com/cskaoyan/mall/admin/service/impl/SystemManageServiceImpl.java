package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRole;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallAdminMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallLogMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallRoleMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallStorageMapper;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.cskaoyan.mall.admin.vo.OptionVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemManageServiceImpl implements SystemManageService {

    @Autowired
    CskaoyanMallStorageMapper storageMapper;

    @Autowired
    CskaoyanMallAdminMapper adminMapper;

    @Autowired
    CskaoyanMallRoleMapper roleMapper;

    @Autowired
    CskaoyanMallLogMapper logMapper;

    @Override
    public List<CskaoyanMallStorage> storageList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<CskaoyanMallStorage> storages = storageMapper.queryAllStorage();
        return storages;
    }

    @Override
    public long countAllStorage() {
        long total = storageMapper.countAllStorage();
        return total;
    }

    @Override
    public List<CskaoyanMallAdmin> adminList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<CskaoyanMallAdmin> admins = adminMapper.queryAllAdmin();
        return admins;
    }

    @Override
    public long countAllAdmin() {
        long total = adminMapper.countAllAdmin();
        return total;
    }

    @Override
    public List<OptionVo> options() {
        List<CskaoyanMallRole> roles =roleMapper.queryAllRole();
        List<OptionVo> options = new ArrayList<>();
        for (CskaoyanMallRole role : roles) {
            OptionVo option = new OptionVo();
            option.setValue(role.getId());
            option.setLabel(role.getName());
            options.add(option);
        }
        return options;
    }

    @Override
    public long countAllLog() {
        long total = logMapper.countAllLog();
        return total;
    }

    @Override
    public List<CskaoyanMallLog> logList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<CskaoyanMallLog> logs = logMapper.queryAllLog();
        return logs;
    }

    @Override
    public List<CskaoyanMallRole> roleList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<CskaoyanMallRole> roles = roleMapper.queryAllRole();
        return roles;
    }

    @Override
    public long countAllRole() {
        long total = roleMapper.countAllRole();
        return total;
    }
}
