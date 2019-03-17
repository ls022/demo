package com.java06.service;

import com.java06.pojo.Types;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Types> getAll();
    Map<String,Object> getPage(int page, int limit,Types types);
    Map<String,Object> updateInfo(Types types);
    Map<String,Object> deleteInfo(Integer id);
    Types getInfoById(Integer id);
}
