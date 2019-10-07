package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.CskaoyanMallOrder;
import com.cskaoyan.mall.admin.bean.CskaoyanMallOrderExample;
import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallOrderMapper;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    CskaoyanMallUserMapper userMapper;

    @Autowired
    CskaoyanMallOrderMapper orderMapper;


    @Override
    public UserOrderVo selectOrderMsg(Integer userId) {
        UserOrderVo orderVo = new UserOrderVo();
        CskaoyanMallOrderExample orderExample = new CskaoyanMallOrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId);
        List<CskaoyanMallOrder> orders = orderMapper.selectByExample(orderExample);
        int unpaid = 0;
        int unship = 0;
        int unrecv = 0;
        int uncomment = 0;
        for (CskaoyanMallOrder order : orders) {
            int i = order.getOrderStatus();
            if (i==101){
                unpaid++;
            }else if (i==201){
                unship++;
            }else if (i==301){
                unrecv++;
            }else if (i==401){
                uncomment++;
            }
        }
        orderVo.setUnpaid(unpaid);
        orderVo.setUnship(unship);
        orderVo.setUnrecv(unrecv);
        orderVo.setUncomment(uncomment);
        return orderVo;
    }

    public boolean registerUser(String mobile, String username, String password) {
       int i = userMapper.registerUser(username,password,mobile);
       if(i != 0){
           return true;
       }
       return false;
    }

    @Override
    public CskaoyanMallUser selectByUsernameAndPassword(String username, String password) {
        CskaoyanMallUser cskaoyanMallUser = userMapper.selectByUsernameAndPassword(username, password);
        return cskaoyanMallUser;
    }

    public Integer queryUserIdByUserName(String principal) {
        Integer id = userMapper.selectIdByUsername(principal);
        return id;
    }
}
