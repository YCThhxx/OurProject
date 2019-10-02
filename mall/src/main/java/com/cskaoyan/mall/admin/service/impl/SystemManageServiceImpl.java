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
import java.util.Date;
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
    public List<CskaoyanMallStorage> storageList(int page, int limit, String key, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        if (name != null) name = "%"+name+"%";
        List<CskaoyanMallStorage> storages = storageMapper.queryAllStorageEqualKeyLikeName(key, name, sort, order);
        return storages;
    }

    @Override
    public long countAllStorage() {
        long total = storageMapper.countAllStorage();
        return total;
    }

    @Override
    public List<CskaoyanMallAdmin> adminList(int page, int limit, String username, String sort, String order) {
        PageHelper.startPage(page, limit);
        if (username != null) username = "%" + username + "%";
        List<CskaoyanMallAdmin> admins = adminMapper.queryAllAdminLikeUsername(sort, order, username);
        return admins;
    }

    @Override
    public long countAllAdmin() {
        long total = adminMapper.countAllAdmin();
        return total;
    }

    @Override
    public List<OptionVo> options() {
        List<CskaoyanMallRole> roles =roleMapper.queryAllRoleLikeUsername(null, null, null);
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
    public List<CskaoyanMallLog> logList(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        if (name != null) name = "%" + name + "%";
        List<CskaoyanMallLog> logs = logMapper.queryAllLogLikeUsername(sort, order, name);
        return logs;
    }

    @Override
    public List<CskaoyanMallRole> roleList(int page, int limit, String name, String sort, String order) {
        if (name != null) name ="%" + name + "%";
        PageHelper.startPage(page, limit);
        List<CskaoyanMallRole> roles = roleMapper.queryAllRoleLikeUsername(sort, order, name);
        return roles;
    }

    @Override
    public long countAllRole() {
        long total = roleMapper.countAllRole();
        return total;
    }

    @Override
    public CskaoyanMallStorage create(String newname, String filename, String type, int size, String url) {
        Date addTime = new Date();
        Date updateTime = new Date();
        CskaoyanMallStorage storage = new CskaoyanMallStorage();
        storage.setKey(newname);
        storage.setName(filename);
        storage.setType(type);
        storage.setSize(size);
        storage.setUrl(url);
        storage.setAddTime(addTime);
        storage.setUpdateTime(updateTime);
        storageMapper.insertSelective(storage);
        //id暂时设置为 未加入数据库前的总量+1
        storage.setId((int)countAllStorage()+1);
        return storage;
    }

    @Override
    public boolean deleteStorage(Integer id) {
        try {
            storageMapper.delete(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CskaoyanMallAdmin createAdmin(CskaoyanMallAdmin admin) {
        Date addTime = new Date();
        Date updateTime = new Date();
        admin.setAddTime(addTime);
        admin.setUpdateTime(updateTime);
        adminMapper.insertSelective(admin);
        admin.setId((int)countAllAdmin());
        return admin;
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        try {
            adminMapper.delete(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateAdmin(CskaoyanMallAdmin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public CskaoyanMallAdmin queryAdminById(Integer id) {
        return adminMapper.queryAdminById(id);
    }

    @Override
    public CskaoyanMallRole createRole(CskaoyanMallRole role) {
        Date addTime = new Date();
        Date updateTime = new Date();
        role.setAddTime(addTime);
        role.setUpdateTime(updateTime);
        roleMapper.insertSelective(role);
        role.setId((int)countAllRole());
        return role;
    }

    @Override
    public void updateRole(CskaoyanMallRole role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public CskaoyanMallRole queryRoleById(Integer id) {
        return roleMapper.queryRoleById(id);
    }

    @Override
    public boolean deleteRole(Integer id) {
        try {
            roleMapper.delete(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void updateStorage(CskaoyanMallStorage storage) {
        storageMapper.updateByPrimaryKeySelective(storage);
    }

    @Override
    public CskaoyanMallStorage queryStorageById(Integer id) {
        return storageMapper.queryStorageById(id);
    }
}
