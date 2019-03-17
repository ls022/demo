package com.java06.mapper;

import com.java06.pojo.Types;

import java.util.List;

public interface TypesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Types record);

    int insertSelective(Types record);

    Types selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Types record);

    int updateByPrimaryKey(Types record);

    List<Types> getAll(Types types);
}