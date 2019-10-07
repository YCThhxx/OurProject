package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;
import com.cskaoyan.mall.admin.service.UserManageService;
import com.cskaoyan.mall.wx.service.AddressService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    UserManageService userService;

    @RequestMapping("list")
    public BaseRespVo addressList(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId = userService.selectByUsername(username);
        List<CskaoyanMallAddress> data = addressService.selectAddressList(userId);
        return BaseRespVo.ok(data);
    }

    @GetMapping("detail")
    public BaseRespVo addressDetail(@RequestBody Map map){
        int id = (int) map.get("id");
        CskaoyanMallAddress data = addressService.selectDetail(id);
        return BaseRespVo.ok(data);
    }

    @GetMapping("save")
    public BaseRespVo addressSave(CskaoyanMallAddress address){
        int data = addressService.saveAddress(address);
        return BaseRespVo.ok(data);
    }
    @GetMapping("list")
    public BaseRespVo regionList(@RequestBody Map map){
        int pid = (int) map.get("pid");
        List<CskaoyanMallRegion> data = addressService.selectRegionList(pid);
        return BaseRespVo.ok(data);
    }

    @PostMapping("delete")
    public BaseRespVo deleteAddress(@RequestParam("id") int id){
        boolean flag = addressService.deleteAddress(id);
        if (flag){
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail();
    }
}
