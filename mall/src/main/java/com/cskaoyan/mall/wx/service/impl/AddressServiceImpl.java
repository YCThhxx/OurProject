package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallAddress;
import com.cskaoyan.mall.admin.bean.CskaoyanMallRegion;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallAddressMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallRegionMapper;
import com.cskaoyan.mall.wx.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    CskaoyanMallAddressMapper addressMapper;

    @Autowired
    CskaoyanMallRegionMapper regionMapper;

    @Override
    public List<CskaoyanMallAddress> selectAddressList(int userId) {
        List<CskaoyanMallAddress> addressList = addressMapper.selectByUserId(userId);
        return addressList;
    }

    @Override
    public CskaoyanMallAddress selectDetail(int id) {
        CskaoyanMallAddress address = addressMapper.selectByPrimaryKey(id);
        return address;
    }

    @Override
    public List<CskaoyanMallRegion> selectRegionList(int pid) {
        List<CskaoyanMallRegion> regionList = regionMapper.selectByPid(pid);
        return regionList;
    }

    @Override
    public int saveAddress(CskaoyanMallAddress address) {
        Date date = new Date();
        address.setAddTime(date);
        address.setUpdateTime(date);
        int id = addressMapper.saveAddress(address);
        return id;
    }

    @Override
    public boolean deleteAddress(int id) {
        int i = addressMapper.deleteByPrimaryKey(id);
        if (i!=0){
            return true;
        }
        return false;
    }
}
