package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallBrand;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallBrandMapper;
import com.cskaoyan.mall.wx.service.WxBrandService;
import com.cskaoyan.mall.wx.vo.brandvo.BrandListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxBrandServiceImpl implements WxBrandService {

    @Autowired
    CskaoyanMallBrandMapper mallBrandMapper;

    @Override
    public BrandListVo brandList(int page, int size) {
        PageHelper.startPage(page,size);
        BrandListVo brandListVo = new BrandListVo();
        List<CskaoyanMallBrand> brands = mallBrandMapper.findAllBrand();
        PageInfo pageInfo = new PageInfo(brands);
        brandListVo.setBrandList(brands);
        brandListVo.setTotalPages(pageInfo.getPages());
        return brandListVo;
    }

    @Override
    public CskaoyanMallBrand brandDetail(int id) {
        CskaoyanMallBrand brand = mallBrandMapper.selectByPrimaryKey(id);
        return brand;
    }
}
