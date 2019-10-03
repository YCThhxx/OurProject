package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.service.IndexService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.admin.vo.DashboardData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/")
public class IndexController {

    @Autowired
    IndexService indexService;

    @RequestMapping(value = "dashboard",method = RequestMethod.GET)
    public BaseResponseVo index(){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        DashboardData data = indexService.getindex();
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "profile/password",method = RequestMethod.GET)
    public BaseResponseVo updatePassword(@Param("newPassword") String newPassword,
                                         @Param("newPassword2") String newaPassword2,
                                         @Param("oldPassword") String oldPassword){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
//        indexService.updatePassword(newPassword,newaPassword2,oldPassword);
        return result;
    }

}
