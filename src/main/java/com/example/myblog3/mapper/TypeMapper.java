package com.example.myblog3.mapper;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {
    Integer savaType(Type type);
    int updateType(Type type);
    int removeType(Type type);
    List<Type> listType();
    List<Type> listTypeByPage();
    List<Blog> findBlogs(Long typeId);
    Type selectTypeByName(String typeName);
    Type selectTypeById(Long typeId);
}
