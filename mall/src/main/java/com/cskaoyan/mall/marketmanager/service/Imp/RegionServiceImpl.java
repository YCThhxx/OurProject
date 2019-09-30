package com.cskaoyan.mall.marketmanager.service.Imp;

import com.cskaoyan.mall.marketmanager.dao.RegionDao;
import com.cskaoyan.mall.marketmanager.dto.RegionInfo;
import com.cskaoyan.mall.marketmanager.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionDao regionDao;

    @Override
    public List<RegionInfo> findAllRegion() {
        List<RegionInfo> allRegion = regionDao.findAllRegion();
        System.out.println(allRegion);
        return allRegion;

    }
}
