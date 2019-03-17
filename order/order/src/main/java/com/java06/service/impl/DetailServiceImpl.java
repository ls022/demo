package com.java06.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java06.mapper.DetailsMapper;
import com.java06.mapper.OrdersMapper;
import com.java06.pojo.Details;
import com.java06.pojo.Goods;
import com.java06.pojo.Orders;
import com.java06.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailsMapper detailsMapper;
    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public Map<String, Object> getList(int page, int limit, Orders orders) {
        PageHelper.startPage(page,limit);//分页工具自动分页
        List<Orders> list=ordersMapper.getAll(orders);//执行查询语句
        PageInfo pi=new PageInfo(list);//查到的集合封装到pageInfo中获取总条数
        long count=pi.getTotal();//获取总条数
        //声明封装json的对象
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public Map<String, Object> getAll(int page, int limit, Details details) {
        PageHelper.startPage(page,limit);//分页工具自动分页
        List<Details> list=detailsMapper.getAll(details);//执行查询语句
        PageInfo pi=new PageInfo(list);//查到的集合封装到pageInfo中获取总条数
        long count=pi.getTotal();//获取总条数
        //声明封装json的对象
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }
}
