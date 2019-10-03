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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
        Date date = new Date();
        CskaoyanMallGoods goods = goodsDetailInfo.getGoods();
        List<CskaoyanMallGoodsAttribute> attributes = goodsDetailInfo.getAttributes();
        List<CskaoyanMallGoodsProduct> products = goodsDetailInfo.getProducts();
        List<CskaoyanMallGoodsSpecification> specifications = goodsDetailInfo.getSpecifications();

        CskaoyanMallGoodsExample goodsExample = new CskaoyanMallGoodsExample();
        CskaoyanMallGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdEqualTo(goods.getId());
        goods.setUpdateTime(date);
        int i = cskaoyanMallGoodsMapper.updateByExample(goods, goodsExample);

        /**
         * 删除没有返回的参数
         */
        ArrayList<Integer> attributeIntegers = new ArrayList();
        for (CskaoyanMallGoodsAttribute attribute : attributes) {
            attributeIntegers.add(attribute.getId());
        }
        CskaoyanMallGoodsAttributeExample goodsAttributeExample1 = new CskaoyanMallGoodsAttributeExample();
        goodsAttributeExample1.createCriteria().andGoodsIdEqualTo(goods.getId()).andIdNotIn(attributeIntegers);
        int i3 = cskaoyanMallGoodsAttributeMapper.deleteByExample(goodsAttributeExample1);

        for (CskaoyanMallGoodsAttribute attribute : attributes) {
            CskaoyanMallGoodsAttributeExample goodsAttributeExample = new CskaoyanMallGoodsAttributeExample();
            CskaoyanMallGoodsAttributeExample.Criteria criteria1 = goodsAttributeExample.createCriteria();
            if(attribute.getId()!=null) {
                criteria1.andGoodsIdEqualTo(goods.getId()).andIdEqualTo(attribute.getId());
                attribute.setUpdateTime(date);
                int i1 = cskaoyanMallGoodsAttributeMapper.updateByExample(attribute, goodsAttributeExample);
            }else {
                attribute.setGoodsId(goods.getId());
                attribute.setAddTime(date);
                attribute.setUpdateTime(date);
                attribute.setDeleted(false);
                cskaoyanMallGoodsAttributeMapper.insert(attribute);
            }
        }

        /**
         * 删除没有返回的规格
         */
        ArrayList<Integer> integers = new ArrayList<>();
        for (CskaoyanMallGoodsSpecification specification : specifications) {
            integers.add(specification.getId());
        }
        CskaoyanMallGoodsSpecificationExample goodsSpecificationExample1 = new CskaoyanMallGoodsSpecificationExample();
        goodsSpecificationExample1.createCriteria().andGoodsIdEqualTo(goods.getId()).andIdNotIn(integers);
        int i2 = cskaoyanMallGoodsSpecificationMapper.deleteByExample(goodsSpecificationExample1);

        for (CskaoyanMallGoodsSpecification specification : specifications) {
            CskaoyanMallGoodsSpecificationExample goodsSpecificationExample = new CskaoyanMallGoodsSpecificationExample();
            CskaoyanMallGoodsSpecificationExample.Criteria criteria1 = goodsSpecificationExample.createCriteria();
            if (specification.getId()!=null) {
                criteria1.andGoodsIdEqualTo(goods.getId()).andIdEqualTo(specification.getId());
                specification.setUpdateTime(date);
                int i1 = cskaoyanMallGoodsSpecificationMapper.updateByExample(specification, goodsSpecificationExample);
            }else {
                specification.setGoodsId(goods.getId());
                specification.setAddTime(date);
                specification.setUpdateTime(date);
                specification.setDeleted(false);
                cskaoyanMallGoodsSpecificationMapper.insert(specification);
            }
        }

        for (CskaoyanMallGoodsProduct product : products) {
            CskaoyanMallGoodsProductExample goodsProductExample = new CskaoyanMallGoodsProductExample();
            CskaoyanMallGoodsProductExample.Criteria criteria1 = goodsProductExample.createCriteria();
            if (product.getGoodsId()!=null) {
                criteria1.andGoodsIdEqualTo(goods.getId()).andIdEqualTo(product.getId());
                product.setUpdateTime(date);
                int i1 = cskaoyanMallGoodsProductMapper.updateByExample(product, goodsProductExample);
            }else {
                criteria1.andGoodsIdEqualTo(goods.getId());
                int i1 = cskaoyanMallGoodsProductMapper.deleteByExample(goodsProductExample);
                product.setId(null);
                product.setGoodsId(goods.getId());
                product.setAddTime(date);
                product.setUpdateTime(date);
                product.setDeleted(false);
                cskaoyanMallGoodsProductMapper.insert(product);
            }
        }
        return true;
    }

    @Override
    public void createGoods(GoodsDetailInfo goodsDetailInfo) {
        Date date = new Date();
        CskaoyanMallGoods goods = goodsDetailInfo.getGoods();
        List<CskaoyanMallGoodsAttribute> attributes = goodsDetailInfo.getAttributes();
        List<CskaoyanMallGoodsSpecification> specifications = goodsDetailInfo.getSpecifications();
        List<CskaoyanMallGoodsProduct> products = goodsDetailInfo.getProducts();

        goods.setAddTime(date);
        goods.setUpdateTime(date);
        goods.setDeleted(false);
        int insert = cskaoyanMallGoodsMapper.insert(goods);
        CskaoyanMallGoodsExample mallGoodsExample = new CskaoyanMallGoodsExample();
        CskaoyanMallGoodsExample.Criteria criteria = mallGoodsExample.createCriteria();
        criteria.andNameEqualTo(goods.getName()).andUnitEqualTo(goods.getUnit()).andBriefEqualTo(goods.getBrief()).andCategoryIdEqualTo(goods.getCategoryId()).andBrandIdEqualTo(goods.getBrandId());
        List<CskaoyanMallGoods> cskaoyanMallGoods = cskaoyanMallGoodsMapper.selectByExample(mallGoodsExample);
        CskaoyanMallGoods newGoods = cskaoyanMallGoods.get(1);

        for (CskaoyanMallGoodsAttribute attribute : attributes) {
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            attribute.setGoodsId(newGoods.getId());
            attribute.setDeleted(false);
            int insert1 = cskaoyanMallGoodsAttributeMapper.insert(attribute);
        }

        for (CskaoyanMallGoodsSpecification specification : specifications) {
            specification.setGoodsId(newGoods.getId());
            specification.setAddTime(date);
            specification.setUpdateTime(date);
            specification.setDeleted(false);
            int insert1 = cskaoyanMallGoodsSpecificationMapper.insert(specification);
        }

        for (CskaoyanMallGoodsProduct product : products) {
            BigDecimal price = product.getPrice();
            Integer number = product.getNumber();
            String url = product.getUrl();
            String[] specifications1 = product.getSpecifications();
            for (String s : specifications1) {
                CskaoyanMallGoodsProduct goodsProduct = new CskaoyanMallGoodsProduct();
                goodsProduct.setAddTime(date);
                goodsProduct.setGoodsId(newGoods.getId());
                goodsProduct.setNumber(number);
                goodsProduct.setPrice(price);
                goodsProduct.setUrl(url);
                String[] sp = {s};
                goodsProduct.setSpecifications(sp);
                goodsProduct.setDeleted(false);
                int insert1 = cskaoyanMallGoodsProductMapper.insert(goodsProduct);
            }
        }

    }

}
