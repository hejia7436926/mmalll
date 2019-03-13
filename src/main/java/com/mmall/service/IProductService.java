package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

public interface IProductService {
    /**
     * 保存或者修改
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 产品上下架
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    /**
     * 获取详情
     */
    ServerResponse<ProductDetailVo> managerProductDetail(Integer productId);

    /**
     * 展示产品
     */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    /**
     * 搜索产品
     */
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    /**
     * 获取到产品详情
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
     * 门户获取产品list
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
}
