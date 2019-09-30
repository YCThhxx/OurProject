package com.cskaoyan.mall.marketmanager.dao;

import com.cskaoyan.mall.marketmanager.dto.RegionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface RegionDao {
    public List<RegionInfo> findAllRegion();

    public List<RegionInfo> findRegionInfoByparentId(int RegionId);

}
