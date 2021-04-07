package com.example.myblog3.service;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;

import java.util.List;

public interface TagService {
    Integer addTag(Tag tag);
    int updateTag(Tag tag);
    int deleteTag(Tag tag);
    PageResult findTagByPage(PageRequest pageRequest);
    List<Tag> findAllTag();
    List<Blog> findBlogsByPage(Long tagId,PageRequest pageRequest);
    Tag findTagByName(String tagName);
    Tag findTagById(Long tagId);
}
