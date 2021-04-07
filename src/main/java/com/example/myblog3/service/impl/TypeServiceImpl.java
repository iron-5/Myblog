package com.example.myblog3.service.impl;

import com.example.myblog3.domain.Type;
import com.example.myblog3.mapper.TypeMapper;
import com.example.myblog3.service.TypeService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import com.example.myblog3.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public Integer addType(Type type) {
        Integer result = typeMapper.savaType(type);
        return result;
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public int deleteType(Type type) {
        return typeMapper.removeType(type);
    }

    @Override
    public PageResult findTypeByPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public PageResult findBlogs(Long typeId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Type findTypeByName(String typeName) {
        return typeMapper.selectTypeByName(typeName);
    }

    @Override
    public Type findTypeById(Long typeId) {
        return typeMapper.selectTypeById(typeId);
    }

    @Override
    public List<Type> findAllType() {
        return typeMapper.listType();
    }

    private PageInfo<Type> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize,"type_id");
        List<Type> typeMenus =typeMapper.listTypeByPage();
        return new PageInfo<Type>(typeMenus);
    }
}
