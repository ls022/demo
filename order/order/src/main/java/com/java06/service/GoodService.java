package com.java06.service;

import com.java06.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodService {
    List<Goods> getPage();

    Map<String,Object> getList(int page, int limit,Goods goods);

    Map<String,Object> updateGood(Goods goods);

    Map<String,Object> deleteGood(Goods goods);

    Goods getGoodById(Integer id);

    List<Goods> getHot(int page,int limit);
}
