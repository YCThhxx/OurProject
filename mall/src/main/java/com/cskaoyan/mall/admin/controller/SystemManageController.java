package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.ItemsVo;
import com.cskaoyan.mall.admin.vo.OptionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemManageController {

    @Autowired
    SystemManageService systemManageService;

    @RequestMapping("admin/storage/list")
    public BaseResponseVo storageList(int page, int limit, String sort, String order){

        List<CskaoyanMallStorage> storages = systemManageService.storageList(page, limit, sort, order);
        long total = systemManageService.countAllStorage();
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (storages != null){
            ItemsVo itemsVo = new ItemsVo();
            itemsVo.setTotal(total);
            itemsVo.setItems(storages);

            baseResponseVo.setData(itemsVo);
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }
        return baseResponseVo;
    }

    @RequestMapping("admin/admin/list")
    public BaseResponseVo adminList(int page, int limit, String sort, String order){

        List<CskaoyanMallAdmin> admins = systemManageService.adminList(page, limit, sort, order);
        long total = systemManageService.countAllAdmin();
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (admins != null){
            ItemsVo itemsVo = new ItemsVo();
            itemsVo.setTotal(total);
            itemsVo.setItems(admins);

            baseResponseVo.setData(itemsVo);
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }
        return baseResponseVo;
    }

    @RequestMapping("admin/role/options")
    public BaseResponseVo options(){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        List<OptionVo> optionVos = systemManageService.options();
        System.out.println(optionVos);
        if (optionVos != null){
            baseResponseVo.setData(optionVos);
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }
        return baseResponseVo;
    }

    @RequestMapping("admin/log/list")
    public BaseResponseVo logList(int page, int limit, String sort, String order){

        List<CskaoyanMallLog> logs = systemManageService.logList(page, limit, sort, order);
        long total = systemManageService.countAllLog();
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        if (logs != null){
            ItemsVo itemsVo = new ItemsVo();
            itemsVo.setTotal(total);
            itemsVo.setItems(logs);

            baseResponseVo.setData(itemsVo);
            baseResponseVo.setErrmsg("成功");
            baseResponseVo.setErrno(0);
        }
        return baseResponseVo;
    }
}
