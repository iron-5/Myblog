package com.example.myblog3.mapper;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.util.PageResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    Integer savaTag(Tag tag);
    int updateTag(Tag tag);
    int removeTag(Tag tag);
    List<Tag> listTagByPage();
    List<Blog> findBlogs(Long tagId);
    Tag selectTagByName(String tagName);
    Tag selectTagById(Long tagId);
    List<Tag> listTag();

}
