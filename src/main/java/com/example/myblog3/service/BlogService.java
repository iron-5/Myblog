package com.example.myblog3.service;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.domain.User;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BlogService {
    int addBlog(Blog blog ,User user);
    int removeBlog(Blog blog);
    int updateBlog(Blog oldBlog, Blog newBlog);
    PageResult findBlogByPage(PageRequest pageRequest);
    PageResult searchBlogs(PageRequest pageRequest, Type type, List<Tag> tags,
                           String content);
    Blog getBlogById(Long blogId);
    List<Blog> listBlog();
    PageResult listBlogsByTypeId(Long typeId, PageRequest pageRequest);
    PageResult listBlogsByTagId(Long tagId, PageRequest pageRequest);
}
