package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.KeyWordService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/keyword")
public class KeyWordController {

    @Autowired
    private KeyWordService keyWordService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponseVo keyWord(@Param("page") int page, @Param("limit") int limit,
                                    @Param("sort") String sort, @Param("order") String order){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        PageBean branddata = keyWordService.showKeyByPage(page,limit,sort,order);
        result.setData(branddata);
        return result;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public BaseResponseVo addKeyWord(@RequestBody CskaoyanMallKeyword cskaoyanMallKeyword){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        CskaoyanMallKeyword data = keyWordService.addKeyWord(cskaoyanMallKeyword);
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResponseVo updateKeyWord(@RequestBody CskaoyanMallKeyword cskaoyanMallKeyword){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        CskaoyanMallKeyword data = keyWordService.updateKeyWord(cskaoyanMallKeyword);
        result.setData(data);
        return result;
    }


}
