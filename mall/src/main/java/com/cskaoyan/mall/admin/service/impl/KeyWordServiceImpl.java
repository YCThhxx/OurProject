package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallKeyword;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.convert.Date2StringConvert;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallKeywordMapper;
import com.cskaoyan.mall.admin.service.KeyWordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KeyWordServiceImpl implements KeyWordService {

    @Autowired
    CskaoyanMallKeywordMapper cskaoyanMallKeywordMapper;

    @Override
    public PageBean showKeyByPage(int page, int limit, String sort, String order) {
        String orderBy = sort +" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List keyList =  cskaoyanMallKeywordMapper.showKeyByPage();
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(keyList);
        PageInfo<CskaoyanMallKeyword> pageInfo = new PageInfo<>(keyList);
        long total = pageInfo.getTotal();
        pageBean.setTotal(total);
        return pageBean;
    }

    /**
     * 添加keyword并返回详细信息
     */
    @Override
    public CskaoyanMallKeyword addKeyWord(CskaoyanMallKeyword cskaoyanMallKeyword) {
        Date addTime = new Date();
        cskaoyanMallKeyword.setAddTime(addTime);
        cskaoyanMallKeyword.setUpdateTime(addTime);
        int id = cskaoyanMallKeywordMapper.addKeyWord(cskaoyanMallKeyword);
        cskaoyanMallKeyword.setId(id);
        return cskaoyanMallKeyword;
    }

    /**
     * 更新keyword并返回详细信息
     */
    @Override
    public CskaoyanMallKeyword updateKeyWord(CskaoyanMallKeyword cskaoyanMallKeyword) {
        Date updateTime = new Date();
        cskaoyanMallKeyword.setUpdateTime(updateTime);
        int id = cskaoyanMallKeywordMapper.updateByPrimaryKey(cskaoyanMallKeyword);
        return cskaoyanMallKeyword;
    }
}
