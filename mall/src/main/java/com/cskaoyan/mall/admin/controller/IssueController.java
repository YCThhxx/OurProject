package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.service.IssueService;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponseVo viewIssue(@Param("page") int page, @Param("limit") int limit,
                                      @Param("sort") String sort, @Param("order") String order,
                                      @Param("question") String  question){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        PageBean data = issueService.showIssueByPage(page,limit,sort,order,question);
        result.setData(data);
        return result;
    }

    /**
     * 编辑
     * @param cskaoyanMallIssue
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public BaseResponseVo updateIssue(@RequestBody CskaoyanMallIssue cskaoyanMallIssue){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        CskaoyanMallIssue data = issueService.updateIssue(cskaoyanMallIssue);
        result.setData(data);
        return result;
    }

    /**
     * t添加问题
     * @param cskaoyanMallIssue
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public BaseResponseVo addIssue(@RequestBody CskaoyanMallIssue cskaoyanMallIssue){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        CskaoyanMallIssue data = issueService.addIssue(cskaoyanMallIssue);
        result.setData(data);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public BaseResponseVo deleteIssue(@RequestBody CskaoyanMallIssue cskaoyanMallIssue){
        BaseResponseVo<Object> result = new BaseResponseVo<>();
        result.setErrmsg("成功");
        result.setErrno(0);
        issueService.deleteIssue(cskaoyanMallIssue);
        return result;
    }
}
