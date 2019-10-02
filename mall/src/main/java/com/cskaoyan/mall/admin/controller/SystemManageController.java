package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAdmin;
import com.cskaoyan.mall.admin.bean.CskaoyanMallLog;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRole;
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
        if (storages != null){
            BaseResponseVo ok = ok(storages, total);
            return ok;
        }
        return null;

    }

    @RequestMapping("admin/admin/list")
    public BaseResponseVo adminList(int page, int limit, String sort, String order){

        List<CskaoyanMallAdmin> admins = systemManageService.adminList(page, limit, sort, order);
        long total = systemManageService.countAllAdmin();
        if (admins != null){
            BaseResponseVo ok = ok(admins, total);
            return ok;
        }
        return null;
    }

    @RequestMapping("admin/role/options")
    public BaseResponseVo options(){
        List<OptionVo> optionVos = systemManageService.options();
        if (optionVos != null){
            BaseResponseVo ok = BaseResponseVo.ok(optionVos);
            return ok;
        }
        return null;
    }

    @RequestMapping("admin/log/list")
    public BaseResponseVo logList(int page, int limit, String sort, String order){

        List<CskaoyanMallLog> logs = systemManageService.logList(page, limit, sort, order);
        long total = systemManageService.countAllLog();
        if (logs != null){
            BaseResponseVo ok = ok(logs, total);
            return ok;
        }
        return null;
    }

    @RequestMapping("admin/role/list")
    public BaseResponseVo roleList(int page, int limit, String sort, String order){

        List<CskaoyanMallRole> roles = systemManageService.roleList(page, limit, sort, order);
        long total = systemManageService.countAllRole();
        if (roles != null){
            BaseResponseVo ok = ok(roles, total);
            return ok;
        }
        return null;
    }

    private BaseResponseVo ok(List<?> data, long total){
        ItemsVo itemsVo = new ItemsVo();
        itemsVo.setTotal(total);
        itemsVo.setItems(data);
        BaseResponseVo ok = BaseResponseVo.ok(itemsVo);
        return ok;
    }
}
