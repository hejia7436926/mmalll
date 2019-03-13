package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

public interface IShippingService {

    /**添加*/
    ServerResponse add(Integer userId, Shipping shipping);

    /**删除*/
    ServerResponse del(Integer userId, Integer shippingId);

    /**修改*/
    ServerResponse update(Integer userId, Shipping shipping);

    /**查询*/
    ServerResponse<Shipping> select(Integer userId,Integer shippingId);

    /**展示*/
    ServerResponse<PageInfo> list(Integer userId,int pageNum,int pageSize);
}
