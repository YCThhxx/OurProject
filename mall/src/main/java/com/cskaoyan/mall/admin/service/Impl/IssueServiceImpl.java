package com.cskaoyan.mall.admin.service.Impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallIssue;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallIssueMapper;
import com.cskaoyan.mall.admin.service.IssueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    CskaoyanMallIssueMapper cskaoyanMallIssueMapper;

    @Override
    public PageBean showIssueByPage(int page, int limit, String sort, String order, String question) {
        String orderBy = sort +" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List keyList =  cskaoyanMallIssueMapper.showIssueByPage(question);
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(keyList);
        PageInfo<CskaoyanMallIssueMapper> pageInfo = new PageInfo<>(keyList);
        long total = pageInfo.getTotal();
        pageBean.setTotal(total);
        return pageBean;
    }

    /**
     * 添加Issue并返回详细信息
     */
    @Override
    public CskaoyanMallIssue addIssue(CskaoyanMallIssue cskaoyanMallIssue) {
        Date addTime = new Date();
        cskaoyanMallIssue.setAddTime(addTime);
        cskaoyanMallIssue.setUpdateTime(addTime);
        int id = cskaoyanMallIssueMapper.addIssue(cskaoyanMallIssue);
        cskaoyanMallIssue.setId(id);
        return cskaoyanMallIssue;
    }

    /**
     * 更新Issue并返回详细信息
     */
    @Override
    public CskaoyanMallIssue updateIssue(CskaoyanMallIssue cskaoyanMallIssue) {
        Date updateTime = new Date();
        cskaoyanMallIssue.setUpdateTime(updateTime);
        int id = cskaoyanMallIssueMapper.updateByPrimaryKeySelective(cskaoyanMallIssue);
        return cskaoyanMallIssue;
    }


    @Override
    public boolean deleteIssue(CskaoyanMallIssue cskaoyanMallIssue) {
        Integer id = cskaoyanMallIssue.getId();
        int i = cskaoyanMallIssueMapper.deleteByPrimaryKey(id);
        if (i != 0){
            return true;
        }
        return false;
    }
}
