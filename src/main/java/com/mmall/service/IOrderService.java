package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

public interface IOrderService {
    /**支付*/
    ServerResponse pay(Long orderNo,Integer userId,String path);
    /**支付回调*/
    ServerResponse aliCallback(Map<String,String> params);

    /**校验是否有该订单*/
    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);

    /**创建订单*/
    ServerResponse create(Integer userId,Integer shippingId);

    /**取消订单*/
    ServerResponse<String> cancel(Integer userId,Long orderNo);
}
