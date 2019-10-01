package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;

import java.util.List;

public interface SystemManageService {
    List<CskaoyanMallStorage> list(int page, int limit, String sort, String order);

    int countAll();
}
