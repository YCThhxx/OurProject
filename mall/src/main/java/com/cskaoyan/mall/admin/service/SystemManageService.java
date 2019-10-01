package com.cskaoyan.mall.admin.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.vo.OptionVo;

import java.util.List;

public interface SystemManageService {
    List<CskaoyanMallStorage> storageList(int page, int limit, String sort, String order);

    long countAllStorage();

    List<CskaoyanMallAdmin> adminList(int page, int limit, String sort, String order);

    long countAllAdmin();

    List<OptionVo> options();

    long countAllLog();

    List<CskaoyanMallLog> logList(int page, int limit, String sort, String order);
}
