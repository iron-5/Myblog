package com.example.myblog3.service.impl;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.domain.User;
import com.example.myblog3.service.BlogService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogServiceImplTest {
    @Autowired
    private BlogService blogService;

    @Test
    void addBlog() {

        Blog blog = new Blog();
        blog.setTitle("first blog!");
        blog.setBlogContent("this is my first blog!");
        blog.setDescription("this is my first blog!!!");
        blog.setFlag("原创");
        blog.setCreateTime(new Date());
        blog.setViewCount(0);
        blog.setRecommended(true);
        blog.setPublished(false);
        Type type = new Type();
        type.setTypeId(Long.valueOf(1));
        blog.setType(type);
        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setTagId(Long.valueOf(6));
        tags.add(tag);
        blog.setTags(tags);
        User user = new User();
        user.setUserId(Long.valueOf(1));
        blogService.addBlog(blog,user);
    }

    @Test
    void removeBlog() {

    }

    @Test
    void updateBlog() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(2);
        pageRequest.setPageNum(1);
        PageResult blog = blogService.searchBlogs(pageRequest, null, null, "this");
        Blog blog1 = (Blog)blog.getContent().get(0);
        System.out.println(blog1);
        Blog blog2 = blog1;
        Tag tag = new Tag();
        tag.setTagId(Long.valueOf(2));
        blog2.getTags().clear();
        blog2.getTags().add(tag);

        blogService.updateBlog(blog1, blog2);
    }

    @Test
    void findBlogByPage() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(2);
        pageRequest.setPageNum(1);
        PageResult result = blogService.findBlogByPage(pageRequest);
        System.out.println(result);
    }

    @Test
    void searchBlogs() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(2);
        pageRequest.setPageNum(1);
        PageResult blog = blogService.searchBlogs(pageRequest, null, null, "title");
        System.out.println(blog);
    }
    @Test
    void listBlogs(){
       List<Blog> blogs=blogService.listBlog();
        System.out.println(blogs);
    }
}