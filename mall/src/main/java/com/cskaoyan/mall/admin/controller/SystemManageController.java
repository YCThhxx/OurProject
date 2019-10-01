package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.StorageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemManageController {

    @Autowired
    SystemManageService systemManageService;

    @RequestMapping("admin/storage/list")
    public BaseResponseVo list(int page, int limit, String sort, String order){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        List<CskaoyanMallStorage> storages = systemManageService.list(page, limit, sort, order);
        int total = systemManageService.countAll();
        if (storages != null){
            StorageVo storageVo = new StorageVo();
            storageVo.setTotal(total);
            storageVo.setItems(storages);

            baseResponseVo.setData(storageVo);
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }
        return baseResponseVo;
    }
}
