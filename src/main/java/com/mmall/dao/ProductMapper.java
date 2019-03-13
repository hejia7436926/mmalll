package com.mmall.dao;

import com.mmall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 获取所有的产品信息
     */
    List<Product> selectList();

    /**
     * 产品名跟id查询
     */
    List<Product> selectByNameAndProductId(@Param("productName") String productName, @Param("productId") Integer paroductId);

    /**
     * 产品名跟分类查询
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName") String productName, @Param("categoryIdList") List<Integer> categoryIdList);

}