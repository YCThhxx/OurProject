package com.cskaoyan.mall.wx.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.wx.service.WxGoodsService;
import com.cskaoyan.mall.wx.vo.goodsvo.CategoryVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsCommentVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsDetailVo;
import com.cskaoyan.mall.wx.vo.goodsvo.GoodsSpecificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        GoodsSpecificationVo specificationVo = new GoodsSpecificationVo();
        specificationVo.setName("规格");
        specificationVo.setValueList(valueList);
        specificationVoList.add(specificationVo);
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
}
