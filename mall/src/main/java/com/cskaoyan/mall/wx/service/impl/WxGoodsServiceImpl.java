package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.WxGoodsService;
import com.cskaoyan.mall.wx.vo.goodsvo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WxGoodsServiceImpl implements WxGoodsService {

    @Autowired
    CskaoyanMallCategoryMapper mallCategoryMapper;
    @Autowired
    CskaoyanMallGoodsMapper mallGoodsMapper;
    @Autowired
    CskaoyanMallGoodsAttributeMapper mallGoodsAttributeMapper;
    @Autowired
    CskaoyanMallBrandMapper mallBrandMapper;
    @Autowired
    CskaoyanMallGoodsProductMapper mallGoodsProductMapper;
    @Autowired
    CskaoyanMallCommentMapper mallCommentMapper;
    @Autowired
    CskaoyanMallGrouponRulesMapper mallGrouponRulesMapper;
    @Autowired
    CskaoyanMallIssueMapper mallIssueMapper;
    @Autowired
    CskaoyanMallGoodsSpecificationMapper mallGoodsSpecificationMapper;
    @Autowired
    CskaoyanMallCollectMapper mallCollectMapper;

    @Override
    public int goodsCount() {
        int goodsCount = mallGoodsMapper.selectGoodsTotal();
        return goodsCount;
    }

    @Override
    public CategoryVo goodsCategory(int id) {
        CskaoyanMallCategory category = mallCategoryMapper.selectByPrimaryKey(id);
        if(category==null) return null;
        CategoryVo categoryVo = new CategoryVo();
        List<CskaoyanMallCategory> categories = new ArrayList<>();
        if("L1".equals(category.getLevel())){
            categoryVo.setParentCategory(category);
            categories = mallCategoryMapper.selectByPidOrderId(id);
            boolean flag = true;
            categoryVo.setCurrentCategory(categories.get(0));
            categoryVo.setBrotherCategory(categories);
        } else if("L2".equals(category.getLevel())){
            categoryVo.setCurrentCategory(category);
            categoryVo.setParentCategory(mallCategoryMapper.selectByPrimaryKey(category.getPid()));
            categories = mallCategoryMapper.selectByPidOrderId(category.getPid());
            for (CskaoyanMallCategory cskaoyanMallCategory : categories) {
                if(cskaoyanMallCategory.getId().equals(id)){
                    categories.remove(cskaoyanMallCategory);
                    break;
                }
            }
            categoryVo.setBrotherCategory(categories);
        }
        return categoryVo;
    }

    @Override
    public GoodsDetailVo goodsDetail(Integer userid,int id) {
        CskaoyanMallGoods info = mallGoodsMapper.selectByPrimaryKey(id);
        if(info==null) return null;
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        List<CskaoyanMallGoodsAttribute> attribute = mallGoodsAttributeMapper.selectByGoodsId(id);
        CskaoyanMallBrand brand = mallBrandMapper.selectByPrimaryKey(info.getBrandId());
        GoodsCommentVo comment = mallCommentMapper.selectByValueId(id);
        List<CskaoyanMallGrouponRules> groupon = mallGrouponRulesMapper.selectAllGrouponRulesByGoodsId(id,new Date());
        List<CskaoyanMallIssue> issue = mallIssueMapper.selectAllIssue();
        List<CskaoyanMallGoodsProduct> productList = mallGoodsProductMapper.selectByGoodsId(id);
        List<CskaoyanMallGoodsSpecification> valueList = mallGoodsSpecificationMapper.selectByGoodsId(id);
        List<GoodsSpecificationVo> specificationVoList = new ArrayList<>();
        while(valueList.size()>0){
            List<CskaoyanMallGoodsSpecification> specifications = new ArrayList<>();
            CskaoyanMallGoodsSpecification specification = valueList.remove(0);
            specifications.add(specification);
            for (CskaoyanMallGoodsSpecification cskaoyanMallGoodsSpecification : valueList) {
                if(cskaoyanMallGoodsSpecification.getSpecification().equals(specification.getSpecification())){
                    specifications.add(cskaoyanMallGoodsSpecification);
                    valueList.remove(cskaoyanMallGoodsSpecification);
                }
            }
            GoodsSpecificationVo specificationVo = new GoodsSpecificationVo();
            specificationVo.setName(specification.getSpecification());
            specificationVo.setValueList(specifications);
            specificationVoList.add(specificationVo);
        }
        String shareImage = info.getShareUrl();
        List<GoodsSpecificationVo> specificationList;
        if(userid!=null){
            long userHasCollect = mallCollectMapper.selectHasCollect(userid.intValue(),id);
            goodsDetailVo.setUserHasCollect(userHasCollect);
        }
        goodsDetailVo.setAttribute(attribute);
        goodsDetailVo.setBrand(brand);
        goodsDetailVo.setComment(comment);
        goodsDetailVo.setGroupon(groupon);
        goodsDetailVo.setInfo(info);
        goodsDetailVo.setIssue(issue);
        goodsDetailVo.setProductList(productList);
        goodsDetailVo.setShareImage(shareImage);
        goodsDetailVo.setSpecificationList(specificationVoList);
        return goodsDetailVo;
    }

    @Override
    public List<CskaoyanMallGoods> selectRelated(int id) {
        CskaoyanMallGoods goods = mallGoodsMapper.selectByPrimaryKey(id);
        PageHelper.startPage(1,6);
        List<CskaoyanMallGoods> goodsList = mallGoodsMapper.selectRelated(goods.getCategoryId().intValue());
        return goodsList;
    }

    @Override
    public GoodsListVo getList(String name , int page, int size, String sort, String order, Integer brandId, String keyword, Integer categoryId) {
        GoodsListVo goodsListVo = new GoodsListVo();
        List<CskaoyanMallGoods> goodsList;
        if(name.equals("new")){
            goodsList = mallGoodsMapper.newList();
        }else if(name.equals("hot")){
            goodsList = mallGoodsMapper.hotList();
        }else {
            goodsList = mallGoodsMapper.otherList(brandId,keyword,categoryId);
        }
        List<CskaoyanMallCategory> categories = new ArrayList<>();
        Set<Integer> set = new HashSet();
        for (CskaoyanMallGoods goods : goodsList) {
            set.add(goods.getCategoryId());
        }
        for (Integer i : set) {
            CskaoyanMallCategory category = mallCategoryMapper.selectGroupByCategoryId(i);
            categories.add(category);
        }
        if(sort==null&&order==null){
            PageHelper.startPage(page, size);
        }else{
            String orderBy = sort +" " +order;
            PageHelper.startPage(page, size, orderBy);
        }
        if(name.equals("new")){
            goodsList = mallGoodsMapper.newList();
        }else if(name.equals("hot")){
            goodsList = mallGoodsMapper.hotList();
        }else {
            goodsList = mallGoodsMapper.otherList(brandId,keyword,categoryId);
        }
        PageInfo pageInfo = new PageInfo(goodsList);
        goodsListVo.setCount((int) pageInfo.getTotal());
        goodsListVo.setFilterCategoryList(categories);
        goodsListVo.setGoodsList(goodsList);
        return goodsListVo;
    }

}
