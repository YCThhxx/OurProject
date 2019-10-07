package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.service.UserManageService;
import com.cskaoyan.mall.wx.service.AddressService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    UserManageService userService;

    @Autowired
    WxUserService wxUserService;

    @RequestMapping("list")
    public BaseRespVo addressList(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId = userService.selectByUsername(username);
        List<CskaoyanMallAddress> data = addressService.selectAddressList(userId);
        return BaseRespVo.ok(data);
    }

    @GetMapping("detail")
    public BaseRespVo addressDetail(@RequestParam("id") int id){
        CskaoyanMallAddress data = addressService.selectDetail(id);
        return BaseRespVo.ok(data);
    }

    @PostMapping("save")
    public BaseRespVo addressSave(@RequestBody CskaoyanMallAddress address){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = wxUserService.queryUserIdByUserName(username);
        int data = addressService.saveAddress(address,userId);
        return BaseRespVo.ok(data);
    }

    @PostMapping("delete")
    public BaseRespVo deleteAddress(@RequestBody Map map){
        int id = (int) map.get("id");
        boolean flag = addressService.deleteAddress(id);
        if (flag){
            return BaseRespVo.ok(null);
        }
        return BaseRespVo.fail();
    }
}
