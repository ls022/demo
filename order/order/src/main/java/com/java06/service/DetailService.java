package com.java06.service;

import com.java06.pojo.Details;
import com.java06.pojo.Orders;

import java.util.Map;

public interface DetailService {
    Map<String,Object> getList(int page, int limit, Orders orders);
    Map<String,Object> getAll(int page, int limit, Details details);
}
