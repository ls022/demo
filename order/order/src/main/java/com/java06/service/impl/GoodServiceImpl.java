package com.java06.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java06.mapper.GoodsMapper;
import com.java06.pojo.Goods;
import com.java06.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getPage() {
        return goodsMapper.getAll(new Goods());
    }

    @Override
    public Map<String,Object> getList(int page, int limit,Goods goods) {
        PageHelper.startPage(page,limit);//分页工具自动分页
        List<Goods> list=goodsMapper.getAll(goods);//执行查询语句
        PageInfo pi=new PageInfo(list);//查到的集合封装到pageInfo中获取总条数
        long count=pi.getTotal();//获取总条数
        //声明封装json的对象
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        System.out.println(map);
        return map;
    }

    @Override
    public Map<String, Object> updateGood(Goods goods) {
        Map<String,Object> map=new HashMap<>();
        if(null!=goods.getId()){
            map.put("status",goodsMapper.updateByPrimaryKeySelective(goods));
        }else {
            map.put("status",goodsMapper.insertSelective(goods));
        }
        return map;

//        return (Map<String, Object>) new HashMap<>().put("status",goodsMapper.updateByPrimaryKeySelective(goods));
    }

    @Override
    public Map<String, Object> deleteGood(Goods goods) {
        Map<String,Object> map=new HashMap<>();
        map.put("status",goodsMapper.deleteByPrimaryKey(goods.getId()));
        return map;
    }

    @Override
    public Goods getGoodById(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> getHot(int page, int limit) {
//        PageHelper.startPage(page,limit);
        return goodsMapper.getHot();
    }
}
