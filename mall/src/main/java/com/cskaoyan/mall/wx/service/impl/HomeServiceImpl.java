package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.HomeService;
import com.cskaoyan.mall.wx.vo.homeIndex.FloorGoodsInfo;
import com.cskaoyan.mall.wx.vo.homeIndex.GrouponRulesInfo;
import com.cskaoyan.mall.wx.vo.homeIndex.HomeInfo;
import com.cskaoyan.mall.wx.vo.homeIndex.HomeSystemInfo;
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

    @Autowired
    CskaoyanMallSystemMapper systemMapper;

    @Override
    public HomeInfo selectHomeIndexMsg() {
        String indexnew = systemMapper.getSystemValueById(2);//新品首发
        String indexhot = systemMapper.getSystemValueById(9);//人气推荐
        String indexbrand = systemMapper.getSystemValueById(15);//品牌制造商
        String indextopic = systemMapper.getSystemValueById(16);//主题精选

        String cataloglist = systemMapper.getSystemValueById(13);//分类栏目
        String cataloggoods = systemMapper.getSystemValueById(11);//分类商品

        CskaoyanMallGoodsExample goodsExample1 = new CskaoyanMallGoodsExample();
        int indexNew = Integer.parseInt(indexnew);
        goodsExample1.setLimit(indexNew);
        goodsExample1.createCriteria().andIsNewEqualTo(true).andDeletedEqualTo(false);
        List<CskaoyanMallGoods> cskaoyanMallNewGoods = goodsMapper.selectByExample(goodsExample1);


        List<CskaoyanMallCoupon> cskaoyanMallCoupons = couponMapper.selectCouponList();

        CskaoyanMallCategoryExample categoryExample = new CskaoyanMallCategoryExample();
        categoryExample.createCriteria().andPidEqualTo(0);
        List<CskaoyanMallCategory> cskaoyanMallCategories = categoryMapper.selectByExample(categoryExample);

        //bug1
        List<GrouponRulesInfo> grouponRulesInfoList = grouponRulesMapper.selectGrouponRulesInfo();

        List<CskaoyanMallAd> cskaoyanMallAds = adMapper.selectAdList();

        int indexBrand = Integer.parseInt(indexbrand);
        List<CskaoyanMallBrand> mallBrands = brandMapper.selectBrandListLimit(indexBrand);

        CskaoyanMallGoodsExample goodsExample2 = new CskaoyanMallGoodsExample();
        int indexHot = Integer.parseInt(indexhot);
        goodsExample2.setLimit(indexHot);
        goodsExample2.createCriteria().andIsHotEqualTo(true).andDeletedEqualTo(false);
        List<CskaoyanMallGoods> cskaoyanMallHotGoods = goodsMapper.selectByExample(goodsExample2);

        int indexTopic = Integer.parseInt(indextopic);
        List<CskaoyanMallTopic> topicList = topicMapper.selectTopic(indexTopic);

        int catalogList = Integer.parseInt(cataloglist);
        int catalogGoods = Integer.parseInt(cataloggoods);
        List<FloorGoodsInfo> floorGoodsInfoList = categoryMapper.selectFirstCategories(catalogList);//四个大类
        for (FloorGoodsInfo floorGoodsInfo : floorGoodsInfoList) {
            Integer pid = floorGoodsInfo.getId();
            Integer id = categoryMapper.selectIdByPid(pid);
            List<CskaoyanMallGoods> goodsList = goodsMapper.selectGoodsByCategory(id,catalogGoods);
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
