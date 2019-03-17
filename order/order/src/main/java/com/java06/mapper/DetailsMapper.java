package com.java06.mapper;

import com.java06.pojo.Details;

import java.util.List;

public interface DetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Details record);

    int insertSelective(Details record);

    Details selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Details record);

    int updateByPrimaryKeyWithBLOBs(Details record);

    int updateByPrimaryKey(Details record);

    int betchInsert(List<Details> list);

    List<Details> getAll(Details details);
}