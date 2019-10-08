package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.GrouponService;
import com.cskaoyan.mall.wx.util.DataUtil;
import com.cskaoyan.mall.wx.util.GrouponData2;
import com.cskaoyan.mall.wx.util.GrouponMyData;
import com.cskaoyan.mall.wx.util.HandleOption;
import com.cskaoyan.mall.wx.vo.AvatorData;
import com.cskaoyan.mall.wx.vo.DetailData;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
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
        //包装类
        List<GrouponData2> grouponData2List = new ArrayList<>();
        //查询所有的团购活动
        List<CskaoyanMallGrouponRules> grouponRules = grouponRulesMapper.selectAllGrouponRules();
        //每一种团购活动
        for (CskaoyanMallGrouponRules grouponRule : grouponRules) {
            //优惠的金额
            BigDecimal discount = grouponRule.getDiscount();
            //团购的要求人数
            Integer grouponMember = grouponRule.getDiscountMember();
            Integer goodsId = grouponRule.getGoodsId();
            CskaoyanMallGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
            //原价即专柜价
            BigDecimal counterPrice = goods.getCounterPrice();
            //现价
            BigDecimal grouponPrice = counterPrice.subtract(discount);

            GrouponData2 grouponData2 = new GrouponData2();
            grouponData2.setGroupon_member(grouponMember);
            grouponData2.setGroupon_price(grouponPrice);
            grouponData2.setGoods(goods);
            grouponData2List.add(grouponData2);
        }
        int count = grouponData2List.size();
        DataUtil<List> dataUtil = new DataUtil<>();
        dataUtil.setCount(count);
        dataUtil.setData(grouponData2List);
        return dataUtil;
    }

    @Override
    public DataUtil getGrouponMy(int showType, int userId) {
        DataUtil dataUtil = new DataUtil();
        ArrayList<GrouponMyData> myDatas = new ArrayList<>();
        List<CskaoyanMallGroupon> groupons;
        if (showType == 0) {
            //拿到我发起的团购的订单列表
            groupons = grouponMapper.getGrouponsByme(userId);
        } else {
            //我参加的团购订单列表
            groupons = grouponMapper.getGrouponsHaveMe(userId);
        }
        for (CskaoyanMallGroupon groupon : groupons) {
            GrouponMyData myData = new GrouponMyData();
            Integer orderId = groupon.getOrderId();
            //得到user信息
            CskaoyanMallUser user = userMapper.selectByPrimaryKey(userId);
            String creator = user.getNickname();
            myData.setCreator(creator);
            //得到订单信息
            CskaoyanMallOrder order = orderMapper.selectByPrimaryKey(orderId);
            BigDecimal actualPrice = order.getActualPrice();
            myData.setActualPrice(actualPrice);
            //得到订单的商品列表(根据订单id得到)
            List<CskaoyanMallOrderGoods> goodsList = orderGoodsMapper.queryOrderGoodsByOrderId(orderId);
            myData.setGoodsList(goodsList);
            myData.setGroupon(groupon);
            HandleOption handleOption = new HandleOption();
            Short orderStatus = order.getOrderStatus();
            switch (orderStatus) {
                case 101:
                    myData.setOrderStatusText("未付款");
                    break;
                case 102:
                    myData.setOrderStatusText("用户取消");
                    handleOption.setCancel(true);
                    break;
                case 103:
                    myData.setOrderStatusText("系统取消");
                    break;
                case 201:
                    myData.setOrderStatusText("已付款");
                    handleOption.setPay(true);
                    break;
                case 202:
                    myData.setOrderStatusText("申请退款");
                    break;
                case 203:
                    myData.setOrderStatusText("已退款");
                    handleOption.setRefund(true);
                    break;
                case 301:
                    myData.setOrderStatusText("已发货");
                    break;
                case 401:
                    myData.setOrderStatusText("用户收货");
                    handleOption.setConfirm(true);
                    break;
                case 402:
                    myData.setOrderStatusText("系统收货");
                    break;
                default:
                    break;
            }
            handleOption.setDelete(order.getDeleted());
            myData.setHandleOption(handleOption);
            Integer id = groupon.getId();
            myData.setId(id);
            myData.setCreator(showType == 0 ? true : false);
            List<AvatorData> joiners = grouponMapper.queryJoiners(id);
            int size = joiners.size();
            myData.setJoinerCount(size);
            myData.setOrderId(orderId);
            myData.setOrderSn(order.getOrderSn());
            Integer rulesId = groupon.getRulesId();
            CskaoyanMallGrouponRules rules = grouponRulesMapper.selectByPrimaryKey(rulesId);
            myData.setRules(rules);
            myDatas.add(myData);
        }
        int total = myDatas.size();
        dataUtil.setCount(total);
        dataUtil.setData(myDatas);
        return dataUtil;
    }


    @Override
    public DetailData grouponDetail(int grouponId) {
        //包装类
        DetailData detailData = new DetailData();
       CskaoyanMallGroupon groupon =  grouponMapper.selectByGrouponId(grouponId);
       detailData.setGroupon(groupon);
        Integer orderId = groupon.getOrderId();
        Integer creatorUserId = groupon.getCreatorUserId();
        CskaoyanMallUser user = userMapper.selectByPrimaryKey(creatorUserId);
        AvatorData creator = new AvatorData();
        creator.setAvatar(user.getAvatar());
        creator.setNickname(user.getNickname());
        detailData.setCreator(creator);
        //查询同一个团购活动参加的用户id
        List<AvatorData> joiners = grouponMapper.queryJoiners(grouponId);
        detailData.setJoiners(joiners);
        detailData.setLinkGrouponId(grouponId);
        List<CskaoyanMallOrderGoods> orderGoods = orderGoodsMapper.queryOrderGoodsByOrderId(orderId);
        for (CskaoyanMallOrderGoods orderGood : orderGoods) {
            String[] specifications = orderGood.getSpecifications();
            //此处存疑，一个订单商品应该只有一个规格
            ArrayList<Object> list = new ArrayList<>();
            list.add(specifications);
            orderGood.setGoodsSpecificationValues(list);
            //需要零售价
            Integer goodsId = orderGood.getGoodsId();
            CskaoyanMallGoods cskaoyanMallGoods = goodsMapper.selectByPrimaryKey(goodsId);
            BigDecimal retailPrice = cskaoyanMallGoods.getRetailPrice();
            orderGood.setRetailPrice(retailPrice);
        }
        detailData.setOrderGoods(orderGoods);
        CskaoyanMallOrder orderInfo = orderMapper.selectByPrimaryKey(orderId);
        HandleOption handleOption = new HandleOption();
        //订单状态
        Short orderStatus = orderInfo.getOrderStatus();
        switch (orderStatus){
            case 101:
                orderInfo.setOrderStatusText("未付款");
                break;
            case 102:
                orderInfo.setOrderStatusText("用户取消");
                handleOption.setCancel(true);
                break;
            case 103:
                orderInfo.setOrderStatusText("系统取消");
                break;
            case 201:
                orderInfo.setOrderStatusText("已付款");
                handleOption.setPay(true);
                break;
            case 202:
                orderInfo.setOrderStatusText("申请退款");
                break;
            case 203:
                orderInfo.setOrderStatusText("已退款");
                handleOption.setRefund(true);
                break;
            case 301:
                orderInfo.setOrderStatusText("已发货");
                break;
            case 401:
                orderInfo.setOrderStatusText("用户收货");
                handleOption.setConfirm(true);
                break;
            case 402:
                orderInfo.setOrderStatusText("系统收货");
                break;
            default:
                break;

        }
        handleOption.setDelete(orderInfo.getDeleted());
        orderInfo.setHandleOption(handleOption);
        detailData.setOrderInfo(orderInfo);
        Integer rulesId = groupon.getRulesId();
        CskaoyanMallGrouponRules rules = grouponRulesMapper.selectByPrimaryKey(rulesId);
        detailData.setRules(rules);
        return detailData;
    }
}
