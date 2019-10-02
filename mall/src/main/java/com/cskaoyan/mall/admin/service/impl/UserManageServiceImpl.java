package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.admin.service.UserManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyj
 * @date 2019/10/1 16:09
 */
@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    CskaoyanMallUserMapper userMapper;
    @Autowired
    CskaoyanMallAddressMapper cskaoyanMallAddressMapper;
    @Autowired
    CskaoyanMallRegionMapper cskaoyanMallRegionMapper;
    @Autowired
    CskaoyanMallCollectMapper cskaoyanMallCollectMapper;
    @Autowired
    CskaoyanMallFootprintMapper cskaoyanMallFootprintMapper;
    @Autowired
    CskaoyanMallSearchHistoryMapper cskaoyanMallSearchHistoryMapper;
    @Autowired
    CskaoyanMallFeedbackMapper cskaoyanMallFeedbackMapper;


    //会员管理
    @Override
    public PageBean getPageBean1(int page, int limit, String sort, String order, String username, String mobile) {
        //分页工具
        PageHelper.startPage(page,limit,sort+" "+order);
        //获得一个对象实例
        CskaoyanMallUserExample userExample = new CskaoyanMallUserExample();
        //获得一个经条件筛选后的对象
        CskaoyanMallUserExample.Criteria criteria = userExample.createCriteria();
        if(username !=null && username.trim().length()!=0){
            criteria.andUsernameEqualTo(username);
        }
        if(mobile!=null && mobile.trim().length()!=0){
            criteria.andMobileEqualTo(mobile);
        }
        //来获取符合条件的对象
        List<CskaoyanMallUser> cskaoyanMallUsers = userMapper.selectByExample(userExample);
        PageBean pageBean = getBean(cskaoyanMallUsers);
        return pageBean;

    }

    //收货地址
    @Override
    public PageBean getPageBean2(String page, String limit, String sort, String order, String userId, String name) {
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        //分页工具
        PageHelper.startPage(page1,limit1,sort+" "+order);
        //获得一个对象实例
        CskaoyanMallAddressExample mallAddressExample = new CskaoyanMallAddressExample();
        //获得一个经条件筛选后的对象
        CskaoyanMallAddressExample.Criteria criteria = mallAddressExample.createCriteria();
        if(name !=null && name.trim().length()!=0){
            criteria.andNameEqualTo(name);
        }
        if(userId !=null && userId.trim().length()!=0){
            int uid = Integer.parseInt(userId);
            criteria.andUserIdEqualTo(uid);
        }
        List<UserAddressInfo> userAddressInfos = new ArrayList<>();
        List<CskaoyanMallAddress> cskaoyanMallAddresses = cskaoyanMallAddressMapper.selectByExample(mallAddressExample);
        for (CskaoyanMallAddress cskaoyanMallAddress : cskaoyanMallAddresses) {
            Integer cityId = cskaoyanMallAddress.getCityId();
            String city = cskaoyanMallRegionMapper.selectAddressByCode(cityId);
            Integer provinceId = cskaoyanMallAddress.getProvinceId();
            String province = cskaoyanMallRegionMapper.selectAddressByCode(provinceId);
            Integer areaId = cskaoyanMallAddress.getAreaId();
            String are = cskaoyanMallRegionMapper.selectAddressByCode(areaId);
            UserAddressInfo userAddressInfo = new UserAddressInfo();
            BeanUtils.copyProperties(cskaoyanMallAddress,userAddressInfo);
            userAddressInfo.setArea(are);
            userAddressInfo.setCity(city);
            userAddressInfo.setProvince(province);
            userAddressInfos.add(userAddressInfo);
        }
        PageBean pageBean = getBean(userAddressInfos);
        return pageBean;
    }

    //会员收藏
    @Override
    public PageBean getPageBean3(String page, String limit, String sort, String order, String userId, String valueId) {
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        //分页工具
        PageHelper.startPage(page1,limit1,sort+" "+order);
        CskaoyanMallCollectExample mallCollectExample = new CskaoyanMallCollectExample();
        CskaoyanMallCollectExample.Criteria criteria = mallCollectExample.createCriteria();
        //进行条件筛选
        //当用户id不为空时

        if(userId!=null && userId.trim().length() !=0){
            int uid = Integer.parseInt(userId);
            criteria.andUserIdEqualTo(uid);
        }
        if(valueId!=null && valueId.trim().length() !=0){
            int vid = Integer.parseInt(valueId);
            criteria.andValueIdEqualTo(vid);
        }
        List<CskaoyanMallCollect> cskaoyanMallCollects = cskaoyanMallCollectMapper.selectByExample(mallCollectExample);
        PageBean pageBean = getBean(cskaoyanMallCollects);
        return pageBean;
    }

    //会员足迹
    @Override
    public PageBean getPageBean4(String page, String limit, String sort, String order, String userId, String goodsId) {
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        //分页工具
        PageHelper.startPage(page1,limit1,sort+" "+order);
        CskaoyanMallFootprintExample footprintExample = new CskaoyanMallFootprintExample();
        CskaoyanMallFootprintExample.Criteria criteria = footprintExample.createCriteria();
        if(userId!=null && userId.trim().length()!=0){
            int uid = Integer.parseInt(userId);
            criteria.andUserIdEqualTo(uid);
        }
        if(goodsId!=null && goodsId.trim().length()!=0){
            int gid = Integer.parseInt(goodsId);
            criteria.andGoodsIdEqualTo(gid);
        }
        List<CskaoyanMallFootprint> cskaoyanMallFootprints = cskaoyanMallFootprintMapper.selectByExample(footprintExample);
        PageBean pageBean = getBean(cskaoyanMallFootprints);
        return pageBean;
    }

    //搜索历史
    @Override
    public PageBean getPageBean5(String page, String limit, String sort, String order, String userId, String keyWord) {
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        PageHelper.startPage(page1,limit1,sort+" "+order);
        CskaoyanMallSearchHistoryExample searchHistoryExample = new CskaoyanMallSearchHistoryExample();
        CskaoyanMallSearchHistoryExample.Criteria criteria = searchHistoryExample.createCriteria();
        if(userId!=null && userId.trim().length()!=0){
            int uid = Integer.parseInt(userId);
            criteria.andUserIdEqualTo(uid);
        }
        if(keyWord!=null && keyWord.trim().length()!=0){
            criteria.andKeywordEqualTo(keyWord);
        }
        List<CskaoyanMallSearchHistory> cskaoyanMallSearchHistories = cskaoyanMallSearchHistoryMapper.selectByExample(searchHistoryExample);
        PageBean pageBean = getBean(cskaoyanMallSearchHistories);
        return pageBean;
    }

    //意见反馈
    @Override
    public PageBean getPageBean6(String page, String limit, String sort, String order, String id, String username) {
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        PageHelper.startPage(page1,limit1,sort+" "+order);
        CskaoyanMallFeedbackExample mallFeedbackExample = new CskaoyanMallFeedbackExample();
        CskaoyanMallFeedbackExample.Criteria criteria = mallFeedbackExample.createCriteria();
        if(id!=null && id.trim().length()!=0){
            int id1 = Integer.parseInt(id);
            criteria.andUserIdEqualTo(id1);
        }
        if(username!=null && username.trim().length()!=0){
            criteria.andUsernameEqualTo(username);
        }
        List<CskaoyanMallFeedback> cskaoyanMallFeedbacks = cskaoyanMallFeedbackMapper.selectByExample(mallFeedbackExample);
        PageBean pageBean = getBean(cskaoyanMallFeedbacks);
        return pageBean;
    }

    //获得pagebean
    private PageBean getBean(List lists) {
        long total = new PageInfo<>(lists).getTotal();
        PageBean pageBean = new PageBean();
        pageBean.setItems(lists);
        pageBean.setTotal(total);
        return pageBean;
    }
}
