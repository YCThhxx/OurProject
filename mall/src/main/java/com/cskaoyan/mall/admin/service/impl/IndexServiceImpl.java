package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.admin.service.IndexService;
import com.cskaoyan.mall.admin.vo.DashboardData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    /**
     * 查询商品总数
     * 订单总数
     * 产品总数
     * 用户总数
     * @return
     */

    @Autowired
    CskaoyanMallUserMapper cskaoyanMallUserMapper;
    @Autowired
    CskaoyanMallGoodsMapper cskaoyanMallGoodsMapper;
    @Autowired
    CskaoyanMallGoodsProductMapper cskaoyanMallGoodsProductMapper;
    @Autowired
    CskaoyanMallOrderMapper cskaoyanMallOrderMapper;
    @Autowired
    CskaoyanMallAdminMapper cskaoyanMallAdminMapper;
    @Override
    public DashboardData getindex() {
        DashboardData dashboardData = new DashboardData();
        dashboardData.setGoodsTotal(cskaoyanMallGoodsMapper.selectGoodsTotal());
        dashboardData.setOrderTotal(cskaoyanMallOrderMapper.selectOrdersTotal());
        dashboardData.setProductTotal(cskaoyanMallGoodsProductMapper.selectProductTotal());
        dashboardData.setUserTotal(cskaoyanMallUserMapper.selectUserTotal());
        return dashboardData;
    }

//    @Override
//    public boolean updatePassword(String newPassword, String newaPassword2, String oldPassword) {
//        if(newPassword == newaPassword2){
//            return false;
//        }
//        cskaoyanMallAdminMapper.updatePassword(newPassword)
//    }


}
