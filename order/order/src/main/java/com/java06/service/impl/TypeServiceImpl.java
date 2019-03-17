package com.java06.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java06.mapper.TypesMapper;
import com.java06.pojo.Types;
import com.java06.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypesMapper typesMapper;
    @Override
    public List<Types> getAll() {
        return typesMapper.getAll(new Types());
    }

    @Override
    public Map<String, Object> getPage(int page, int limit, Types types) {
        PageHelper.startPage(page,limit);
        List<Types> list=typesMapper.getAll(types);
        PageInfo<Types> pageInfo=new PageInfo<>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;
    }

    @Override
    public Map<String, Object> updateInfo(Types types) {
        Map<String,Object> map=new HashMap<>();
        if(null!=types.getId()){
            map.put("status",typesMapper.updateByPrimaryKeySelective(types));
        }else{
            map.put("status",typesMapper.insertSelective(types));
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteInfo(Integer id) {
        Map<String,Object> map=new HashMap<>();
        map.put("status",typesMapper.deleteByPrimaryKey(id));
        return map;
    }

    @Override
    public Types getInfoById(Integer id) {
        return typesMapper.selectByPrimaryKey(id);
    }
}
