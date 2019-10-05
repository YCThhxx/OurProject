package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.wx.service.GrouponService;
import com.cskaoyan.mall.wx.util.BaseRespVo;
import com.cskaoyan.mall.wx.util.DataUtil;
import com.cskaoyan.mall.wx.util.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("groupon")
public class GrouponController {

    @Autowired
    GrouponService grouponService;

    @GetMapping("/list")
    public BaseRespVo grouponList(@RequestParam("page") int page,
                                  @RequestParam("size") int size){
        DataUtil dataUtil =  grouponService.getGrouponList(page,size);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setData(dataUtil);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }

    @GetMapping("/my")
    public BaseRespVo grouponMy(HttpServletRequest request, @RequestParam("showType") int showType){
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        if (userId == null) {
            return BaseRespVo.fail();
        }
         userId = userId.intValue();
        DataUtil dataUtil =  grouponService.getGrouponMy(showType,userId);
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setData(dataUtil);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }


}
