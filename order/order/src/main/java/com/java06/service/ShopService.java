package com.java06.service;

import com.java06.pojo.Orders;

import java.util.Map;

public interface ShopService {

    Map<String,Object> getAllList();
    Map<String,Object> doShop(Orders orders,String[] gids,String[] cs);
}
