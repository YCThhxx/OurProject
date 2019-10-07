package com.cskaoyan.mall.wx.service;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;

import java.util.List;

public interface AddressService {
    List<CskaoyanMallAddress> selectAddressList(int userId);


    CskaoyanMallAddress selectDetail(int id);

    List<CskaoyanMallRegion> selectRegionList(int pid);

    int saveAddress(CskaoyanMallAddress address,int userId);

    boolean deleteAddress(int id);
}
