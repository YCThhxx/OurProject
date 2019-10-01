package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallStorageMapper;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemManageServiceImpl implements SystemManageService {

    @Autowired
    CskaoyanMallStorageMapper storageMapper;

    @Override
    public List<CskaoyanMallStorage> list(int page, int limit, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<CskaoyanMallStorage> storages = storageMapper.queryStorage();
        return storages;
    }

    @Override
    public int countAll() {
        int total = storageMapper.countAll();
        return total;
    }
}
