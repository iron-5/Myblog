package com.example.myblog3.service.impl;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.domain.User;
import com.example.myblog3.mapper.BlogMapper;
import com.example.myblog3.service.BlogService;
import com.example.myblog3.service.TagService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import com.example.myblog3.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private TagService tagService;
    //添加博客
    @Override
    public int addBlog(Blog blog, User user) {
        List<Tag> tags = getTags(blog);
        blog.setTags(tags);
        blog.setUser(user);
        blog.setViewCount(0);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        int blog1 = blogMapper.saveBlog(blog);
        blogMapper.saveTags(blog.getTags(), blog);
        return blog1;
    }
    //删除博客 把相应的tag也要删掉
    @Override
    public int removeBlog(Blog blog) {
        int remove1 = blogMapper.removeBlog(blog);
        int remove2 = blogMapper.removeTags(blog);

        if(remove1 > 0 && remove2 > 0){
            return remove1;
        }
        return 0;

    }
//
    @Override
    public int updateBlog(Blog oldBlog, Blog newBlog) {
        List<Tag> tags = getTags(newBlog);
        newBlog.setTags(tags);
        newBlog.setUpdateTime(new Date());
        int update1 = blogMapper.updateBlog(newBlog);
        int update2 = blogMapper.removeTags(oldBlog);
        int update3 = blogMapper.saveTags(newBlog.getTags(), newBlog);
        if(update1>0 && update2>0 && update3>0) return update1;
        else return 0;

    }
//
    private List<Tag> getTags(Blog blog){
        String[] tagsId = blog.getTagsId();
        List<Tag> tags = new ArrayList<>();
        for (String tag:tagsId
        ) {
            Tag t = tagService.findTagById(Long.getLong(tag));
            tags.add(t);
        }
        return tags;
    }
    @Override
    public PageResult findBlogByPage(PageRequest pageRequest) {
        List<Blog> blogs = blogMapper.selectBlogByPage();
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest, blogs));
    }
//
    @Override
    public PageResult searchBlogs(PageRequest pageRequest, Type type, List<Tag> tags, String content) {
        content = "%" + content + "%";
        List<Blog> blogs = blogMapper.searchBlogs(pageRequest, type, tags, content);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest, blogs));
    }

    @Override
    public Blog getBlogById(Long blogId) {
        return blogMapper.selectBlogById(blogId);
    }

    @Override
    public List<Blog> listBlog() {
        return blogMapper.listBlogs();
    }

    @Override
    public PageResult listBlogsByTypeId(Long typeId, PageRequest pageRequest) {
        List<Blog> blogs = blogMapper.selectBlogsByTypeId(typeId);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest, blogs));
    }

    @Override
    public PageResult listBlogsByTagId(Long tagId, PageRequest pageRequest) {
        List<Blog> blogs = blogMapper.selectBlogsByTagId(tagId);
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest, blogs));
    }

    private PageInfo<Blog> getPageInfo(PageRequest pageRequest, List<Blog> blogMenus) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize,"blog_id");
        return new PageInfo<Blog>(blogMenus);
    }

}
