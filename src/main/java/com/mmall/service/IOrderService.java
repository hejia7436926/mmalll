package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

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

    /**查询订单的商品信息*/
    ServerResponse getOrderCartProduct(Integer userId);

    /*获取订单详情*/
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    /**获取订单列表*/
    ServerResponse<PageInfo> getOrderList(Integer userId,int pageNum,int pageSize);

    //backend
    ServerResponse<PageInfo> manageList(int pageNum,int pageSize);
}
