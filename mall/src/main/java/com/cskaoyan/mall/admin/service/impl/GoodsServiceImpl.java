package com.cskaoyan.mall.admin.service.impl;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.mapper.*;
import com.cskaoyan.mall.admin.service.GoodsService;
import com.cskaoyan.mall.admin.vo.BrandInfo;
import com.cskaoyan.mall.admin.vo.CatAndBrandInfo;
import com.cskaoyan.mall.admin.vo.CategoryInfo;
import com.cskaoyan.mall.admin.vo.GoodsDetailInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    CskaoyanMallGoodsMapper cskaoyanMallGoodsMapper;

    @Autowired
    CskaoyanMallCategoryMapper cskaoyanMallCategoryMapper;

    @Autowired
    CskaoyanMallBrandMapper cskaoyanMallBrandMapper;

    @Autowired
    CskaoyanMallGoodsAttributeMapper cskaoyanMallGoodsAttributeMapper;

    @Autowired
    CskaoyanMallGoodsSpecificationMapper cskaoyanMallGoodsSpecificationMapper;

    @Autowired
    CskaoyanMallGoodsProductMapper cskaoyanMallGoodsProductMapper;

    @Override
    public PageBean getListOfGoods(int page, int limit, String sort, String order, String goodsSn, String name) {
        String orderBy = sort+" "+order;
        PageHelper.startPage(page,limit,orderBy);
        List<CskaoyanMallGoods> cskaoyanMallGoods = cskaoyanMallGoodsMapper.selectGoodsList(goodsSn, name);
        PageInfo<CskaoyanMallGoods> goodsPageInfo = new PageInfo<>(cskaoyanMallGoods);
        long total = goodsPageInfo.getTotal();
        PageBean<List> pageBean = new PageBean<>();
        pageBean.setItems(cskaoyanMallGoods);
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public CatAndBrandInfo getListOfCatAndBrand() {
        CatAndBrandInfo catAndBrandInfo = new CatAndBrandInfo();
        List<BrandInfo> brandInfos = cskaoyanMallBrandMapper.selectBrandListForGoods();
        List<CategoryInfo> categoryInfos = cskaoyanMallCategoryMapper.selectCatListForGoods();
        catAndBrandInfo.setCategoryList(categoryInfos);
        catAndBrandInfo.setBrandList(brandInfos);
        return catAndBrandInfo;
    }

    @Override
    public GoodsDetailInfo getDetailOfGoodsById(int id) {
        GoodsDetailInfo goodsDetailInfo = new GoodsDetailInfo();
        CskaoyanMallGoods cskaoyanMallGoods = cskaoyanMallGoodsMapper.selectByPrimaryKey(id);
        goodsDetailInfo.setGoods(cskaoyanMallGoods);

        Integer categoryId = cskaoyanMallGoods.getCategoryId();
        CskaoyanMallCategory cskaoyanMallCategory = cskaoyanMallCategoryMapper.selectByPrimaryKey(categoryId);
        Integer[] categoryIds = new Integer[]{cskaoyanMallCategory.getPid(),categoryId};
        goodsDetailInfo.setCategoryIds(categoryIds);

        CskaoyanMallGoodsAttributeExample goodsAttributeExample = new CskaoyanMallGoodsAttributeExample();
        CskaoyanMallGoodsAttributeExample.Criteria criteria = goodsAttributeExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        List<CskaoyanMallGoodsAttribute> cskaoyanMallGoodsAttributes = cskaoyanMallGoodsAttributeMapper.selectByExample(goodsAttributeExample);
        goodsDetailInfo.setAttributes(cskaoyanMallGoodsAttributes);

        CskaoyanMallGoodsSpecificationExample goodsSpecificationExample = new CskaoyanMallGoodsSpecificationExample();
        CskaoyanMallGoodsSpecificationExample.Criteria criteria1 = goodsSpecificationExample.createCriteria();
        criteria1.andGoodsIdEqualTo(id);
        List<CskaoyanMallGoodsSpecification> cskaoyanMallGoodsSpecifications = cskaoyanMallGoodsSpecificationMapper.selectByExample(goodsSpecificationExample);
        goodsDetailInfo.setSpecifications(cskaoyanMallGoodsSpecifications);

        CskaoyanMallGoodsProductExample goodsProductExample = new CskaoyanMallGoodsProductExample();
        CskaoyanMallGoodsProductExample.Criteria criteria2 = goodsProductExample.createCriteria();
        criteria2.andGoodsIdEqualTo(id);
        List<CskaoyanMallGoodsProduct> cskaoyanMallGoodsProducts = cskaoyanMallGoodsProductMapper.selectByExample(goodsProductExample);
        goodsDetailInfo.setProducts(cskaoyanMallGoodsProducts);
        return goodsDetailInfo;
    }

    @Override
    public boolean deleteGoodsById(Integer id) {
        int i = cskaoyanMallGoodsMapper.deleteByPrimaryKey(id);

        CskaoyanMallGoodsAttributeExample goodsAttributeExample = new CskaoyanMallGoodsAttributeExample();
        CskaoyanMallGoodsAttributeExample.Criteria criteria = goodsAttributeExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        int i1 = cskaoyanMallGoodsAttributeMapper.deleteByExample(goodsAttributeExample);

        CskaoyanMallGoodsSpecificationExample goodsSpecificationExample = new CskaoyanMallGoodsSpecificationExample();
        CskaoyanMallGoodsSpecificationExample.Criteria criteria1 = goodsSpecificationExample.createCriteria();
        criteria1.andGoodsIdEqualTo(id);
        int i2 = cskaoyanMallGoodsSpecificationMapper.deleteByExample(goodsSpecificationExample);

        CskaoyanMallGoodsProductExample goodsProductExample = new CskaoyanMallGoodsProductExample();
        CskaoyanMallGoodsProductExample.Criteria criteria2 = goodsProductExample.createCriteria();
        criteria2.andGoodsIdEqualTo(id);
        int i3 = cskaoyanMallGoodsProductMapper.deleteByExample(goodsProductExample);

        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateGoods(GoodsDetailInfo goodsDetailInfo) {
        CskaoyanMallGoods goods = goodsDetailInfo.getGoods();
        List<CskaoyanMallGoodsAttribute> attributes = goodsDetailInfo.getAttributes();
        List<CskaoyanMallGoodsProduct> products = goodsDetailInfo.getProducts();
        List<CskaoyanMallGoodsSpecification> specifications = goodsDetailInfo.getSpecifications();

        CskaoyanMallGoodsExample goodsExample = new CskaoyanMallGoodsExample();
        CskaoyanMallGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdEqualTo(goods.getId());
        int i = cskaoyanMallGoodsMapper.updateByExample(goods, goodsExample);

        for (CskaoyanMallGoodsAttribute attribute : attributes) {
            CskaoyanMallGoodsAttributeExample goodsAttributeExample = new CskaoyanMallGoodsAttributeExample();
            CskaoyanMallGoodsAttributeExample.Criteria criteria1 = goodsAttributeExample.createCriteria();
            if(attribute.getId()!=null) {
                criteria1.andGoodsIdEqualTo(goods.getId()).andIdEqualTo(attribute.getId());
                int i1 = cskaoyanMallGoodsAttributeMapper.updateByExample(attribute, goodsAttributeExample);
            }else {
                attribute.setGoodsId(goods.getId());
                cskaoyanMallGoodsAttributeMapper.insertSelective(attribute);
            }
        }

        for (CskaoyanMallGoodsSpecification specification : specifications) {
            CskaoyanMallGoodsSpecificationExample goodsSpecificationExample = new CskaoyanMallGoodsSpecificationExample();
            CskaoyanMallGoodsSpecificationExample.Criteria criteria1 = goodsSpecificationExample.createCriteria();
            if (specification.getId()!=null) {
                criteria1.andGoodsIdEqualTo(goods.getId()).andIdEqualTo(specification.getId());
                int i1 = cskaoyanMallGoodsSpecificationMapper.updateByExample(specification, goodsSpecificationExample);
            }else {
                specification.setGoodsId(goods.getId());
                cskaoyanMallGoodsSpecificationMapper.insertSelective(specification);
            }
        }

        for (CskaoyanMallGoodsProduct product : products) {
            CskaoyanMallGoodsProductExample goodsProductExample = new CskaoyanMallGoodsProductExample();
            CskaoyanMallGoodsProductExample.Criteria criteria1 = goodsProductExample.createCriteria();
            if (product.getId()!=null) {
                criteria1.andGoodsIdEqualTo(goods.getId()).andIdEqualTo(product.getId());
                int i1 = cskaoyanMallGoodsProductMapper.updateByExample(product, goodsProductExample);
            }else {
                product.setGoodsId(goods.getId());
                cskaoyanMallGoodsProductMapper.insertSelective(product);
            }
        }

        return true;
    }

    @Override
    public void createGoods(GoodsDetailInfo goodsDetailInfo) {

    }

}
