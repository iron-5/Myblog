package com.example.myblog3.mapper;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.domain.User;
import com.example.myblog3.util.PageRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    int saveBlog(Blog blog);
    //void saveUserId(User user);
    int saveTags(List<Tag> tags,Blog blog);
    int removeBlog(Blog blog);
    int removeTags(Blog blog);
    int updateBlog(Blog blog);
    List<Blog> listBlogs();
    List<Blog> selectBlogByPage();
    List<Blog> searchBlogs(PageRequest pageRequest, Type type,
                           List<Tag> tags, String content);
    Blog selectBlogById(Long blogId);
    List<Blog> selectBlogsByTypeId(Long typeId);
    List<Blog> selectBlogsByTagId(Long tagId);
    List<Blog> selectBlogsByTags(List<Long> tags);
}
