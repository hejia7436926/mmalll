package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    /**用户编号跟订单编号查询商品详情*/
    List<OrderItem> getByOrderNoUserId(Long orderNo,Integer userId);

    /**批量插入订单*/
    void batchInsert(@Param("orderItemList")List<OrderItem> orderItemList);

    /*订单号查询订单*/
    List<OrderItem> getByOrderNo(@Param("orderNo")Long orderNo);
}