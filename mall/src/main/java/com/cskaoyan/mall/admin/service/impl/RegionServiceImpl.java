package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;
import com.cskaoyan.mall.admin.bean.PageBean;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallRegionMapper;
import com.cskaoyan.mall.admin.service.RegionService;
import com.cskaoyan.mall.admin.vo.RegionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    CskaoyanMallRegionMapper cskaoyanMallRegionMapper;

    @Override
    public List<RegionData> getRegions() {
        List<RegionData> list =  cskaoyanMallRegionMapper.getRegions();
       return list;
    }
}
