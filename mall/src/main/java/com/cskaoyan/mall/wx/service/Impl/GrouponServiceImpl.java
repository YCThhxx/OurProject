package com.cskaoyan.mall.wx.service.Impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.GrouponService;
import com.cskaoyan.mall.wx.util.DataUtil;
import com.cskaoyan.mall.wx.util.GrouponData2;
import com.cskaoyan.mall.wx.util.GrouponMyData;
import com.cskaoyan.mall.wx.util.HandleOption;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrouponServiceImpl implements GrouponService {

    @Autowired
    CskaoyanMallGrouponRulesMapper grouponRulesMapper;

    @Autowired
    CskaoyanMallGoodsMapper goodsMapper;

    @Autowired
    CskaoyanMallGrouponMapper grouponMapper;

    @Autowired
    CskaoyanMallUserMapper userMapper;

    @Autowired
    CskaoyanMallOrderMapper orderMapper;

    @Autowired
    CskaoyanMallOrderGoodsMapper orderGoodsMapper;

    @Override
    public DataUtil getGrouponList(int page, int size) {
        PageHelper.startPage(page, size);
        List<CskaoyanMallGoods> goods = goodsMapper.getGoodInfo();
        List<GrouponData2> grouponData2s = null;
        for (CskaoyanMallGoods good : goods) {
            Integer goodId = good.getId();
            BigDecimal retailPrice = good.getRetailPrice();
            CskaoyanMallGrouponRules grouponRules = grouponRulesMapper.getGrouponRulesInfo(goodId);
            BigDecimal discount = grouponRules.getDiscount();
            Integer discountMember = grouponRules.getDiscountMember();
            GrouponData2 data2 = new GrouponData2();
            BigDecimal price = retailPrice.subtract(discount);
            data2.setGroupon_member(discountMember);
            data2.setGroupon_price(price);
            data2.setGoods(good);
            grouponData2s.add(data2);
        }
        PageInfo<GrouponData2> pageInfo = new PageInfo<>();
        long total = pageInfo.getTotal();
        DataUtil<GrouponData2> dataUtil = new DataUtil<>();
        dataUtil.setConut((int)total);
        dataUtil.setData(grouponData2s);
        return dataUtil;
    }

    @Override
    public DataUtil getGrouponMy(int showType, int userId) {
        DataUtil<List> dataUtil = new DataUtil<>();
        //用户的团购订单列表
        List<GrouponMyData> myDatas = new ArrayList<>();
        String creator = null;
        BigDecimal actualPrice = null;
        //团购商品一个订单只能有一个商品，此处注意
        CskaoyanMallOrderGoods goodsList = null;
        CskaoyanMallGrouponRules rules = null;
        HandleOption handleOption = null;
        GrouponMyData myData ;
        List<CskaoyanMallOrderGoods> grouponGoods  = null;
        //拿到我发起的团购的订单列表
        List<CskaoyanMallGroupon> groupons = grouponMapper.getGrouponsByme(userId);
        //我参加的团购订单列表
        List<CskaoyanMallGroupon> groupons1 = grouponMapper.getGrouponsHaveMe(userId);
        int total = 0;
        //发起的团购
        if(showType == 0){
            PageInfo<CskaoyanMallGroupon> pageInfo = new PageInfo<>(groupons);
             total = (int)pageInfo.getTotal();
            for (CskaoyanMallGroupon groupon : groupons) {
                 myData = new GrouponMyData();
                Integer orderId = groupon.getOrderId();
                CskaoyanMallUser user = userMapper.selectByPrimaryKey(userId);
                creator = user.getNickname();
                CskaoyanMallOrder order = orderMapper.selectByPrimaryKey(orderId);
                actualPrice = order.getActualPrice();
                Integer rulesId = groupon.getRulesId();
                rules = grouponRulesMapper.selectByPrimaryKey(rulesId);
                Integer goodsId = rules.getGoodsId();
                //参团活动只能一件商品一个订单（否则活动规则与数据库冲突）
                grouponGoods = orderGoodsMapper.queryGrouponGoods(goodsId);
                handleOption = new HandleOption();
                myData.setCreator(true);
                myData.setActualPrice(actualPrice);
                myData.setCreator(creator);
                myData.setGoodsList(grouponGoods);
                myData.setGroupon(groupon);
                myData.setHandleOption(handleOption);
                myDatas.add(myData);
            }
        }else{
            for (CskaoyanMallGroupon groupon : groupons1) {
                myData = new GrouponMyData();
                Integer orderId = groupon.getOrderId();
                CskaoyanMallUser user = userMapper.selectByPrimaryKey(userId);
                creator = user.getNickname();
                CskaoyanMallOrder order = orderMapper.selectByPrimaryKey(orderId);
                actualPrice = order.getActualPrice();
                Integer rulesId = groupon.getRulesId();
                rules = grouponRulesMapper.selectByPrimaryKey(rulesId);
                Integer goodsId = rules.getGoodsId();
                //参团活动只能一件商品一个订单（否则活动规则与数据库冲突）
                grouponGoods = orderGoodsMapper.queryGrouponGoods(goodsId);
                handleOption = new HandleOption();
                myData.setCreator(true);
                myData.setActualPrice(actualPrice);
                myData.setCreator(creator);
                myData.setGoodsList(grouponGoods);
                myData.setGroupon(groupon);
                myData.setHandleOption(handleOption);
                myDatas.add(myData);
            }
        }
        dataUtil.setConut(total);
        dataUtil.setData(Collections.singletonList(myDatas));
        return dataUtil;
    }
}
