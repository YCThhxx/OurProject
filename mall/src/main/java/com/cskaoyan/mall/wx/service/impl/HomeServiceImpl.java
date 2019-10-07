package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.HomeService;
import com.cskaoyan.mall.wx.vo.homeIndex.FloorGoodsInfo;
import com.cskaoyan.mall.wx.vo.homeIndex.GrouponRulesInfo;
import com.cskaoyan.mall.wx.vo.homeIndex.HomeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    CskaoyanMallGoodsMapper goodsMapper;

    @Autowired
    CskaoyanMallCouponMapper couponMapper;

    @Autowired
    CskaoyanMallCategoryMapper categoryMapper;

    @Autowired
    CskaoyanMallGrouponRulesMapper grouponRulesMapper;

    @Autowired
    CskaoyanMallAdMapper adMapper;

    @Autowired
    CskaoyanMallBrandMapper brandMapper;

    @Autowired
    CskaoyanMallTopicMapper topicMapper;

    @Override
    public HomeInfo selectHomeIndexMsg() {
        CskaoyanMallGoodsExample goodsExample1 = new CskaoyanMallGoodsExample();
        goodsExample1.createCriteria().andIsNewEqualTo(true).andDeletedEqualTo(false);
        List<CskaoyanMallGoods> cskaoyanMallNewGoods = goodsMapper.selectByExample(goodsExample1);

        List<CskaoyanMallCoupon> cskaoyanMallCoupons = couponMapper.selectCouponList();

        CskaoyanMallCategoryExample categoryExample = new CskaoyanMallCategoryExample();
        categoryExample.createCriteria().andPidEqualTo(0);
        List<CskaoyanMallCategory> cskaoyanMallCategories = categoryMapper.selectByExample(categoryExample);

        //bug1
        List<GrouponRulesInfo> grouponRulesInfoList = grouponRulesMapper.selectGrouponRulesInfo();

        List<CskaoyanMallAd> cskaoyanMallAds = adMapper.selectAdList();

        List<CskaoyanMallBrand> mallBrands = brandMapper.selectBrandListLimit4();

        CskaoyanMallGoodsExample goodsExample2 = new CskaoyanMallGoodsExample();
        goodsExample2.createCriteria().andIsHotEqualTo(true).andDeletedEqualTo(false);
        List<CskaoyanMallGoods> cskaoyanMallHotGoods = goodsMapper.selectByExample(goodsExample2);

        List<CskaoyanMallTopic> topicList = topicMapper.selectTopic3();


        List<FloorGoodsInfo> floorGoodsInfoList = categoryMapper.selectFirstCategories4();//四个大类
        for (FloorGoodsInfo floorGoodsInfo : floorGoodsInfoList) {
            Integer pid = floorGoodsInfo.getId();
            Integer id = categoryMapper.selectIdByPid(pid);
            List<CskaoyanMallGoods> goodsList = goodsMapper.selectGoodsByCategory2(id);
            floorGoodsInfo.setGoodsList(goodsList);
        }

        HomeInfo homeInfo = new HomeInfo();
        homeInfo.setNewGoodsList(cskaoyanMallNewGoods);
        homeInfo.setCouponList(cskaoyanMallCoupons);
        homeInfo.setChannel(cskaoyanMallCategories);
        homeInfo.setGrouponList(grouponRulesInfoList);
        homeInfo.setBanner(cskaoyanMallAds);
        homeInfo.setBrandList(mallBrands);
        homeInfo.setHotGoodsList(cskaoyanMallHotGoods);
        homeInfo.setTopicList(topicList);
        homeInfo.setFloorGoodsList(floorGoodsInfoList);
        return homeInfo;
    }
}
