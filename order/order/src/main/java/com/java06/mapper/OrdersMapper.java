package com.java06.mapper;

import com.java06.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKeyWithBLOBs(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> getAll(Orders orders);
}