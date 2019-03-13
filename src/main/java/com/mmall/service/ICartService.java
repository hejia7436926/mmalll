package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

public interface ICartService {

    /**
     * 添加
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
     * 修改
     */
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    /**
     * 展示
     */
    ServerResponse<CartVo> list(Integer userId);

    /**
     * 删除
     */
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    /**
     * 全选
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);

    /**
     * 查询数量
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);

}
