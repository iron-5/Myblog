package com.example.myblog3.service;

import com.example.myblog3.domain.Type;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;

import java.util.List;

public interface TypeService {
    Integer addType(Type type);
    int updateType(Type type);
    int deleteType(Type type);
    PageResult findTypeByPage(PageRequest pageRequest);
    PageResult findBlogs(Long typeId, PageRequest pageRequest);
    Type findTypeByName(String typeName);
    Type findTypeById(Long typeId);
    List<Type> findAllType();
}
