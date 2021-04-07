package com.example.myblog3.service.impl;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.Type;
import com.example.myblog3.mapper.TagMapper;
import com.example.myblog3.mapper.TypeMapper;
import com.example.myblog3.service.TagService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import com.example.myblog3.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public Integer addTag(Tag tag) {
        Integer result = tagMapper.savaTag(tag);
        return result;
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public int deleteTag(Tag tag) {
        return tagMapper.removeTag(tag);
    }

    @Override
    public PageResult findTagByPage(PageRequest pageRequest) {
        List<Tag> tagMenus =tagMapper.listTagByPage();
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,tagMenus));
    }

    @Override
    public List<Tag> findAllTag() {
        return tagMapper.listTag();
    }

    @Override
    public List<Blog> findBlogsByPage(Long tagId,PageRequest pageRequest) {
        List<Blog> tagMenus =tagMapper.findBlogs(tagId);
        return tagMapper.findBlogs(tagId);
    }

    @Override
    public Tag findTagByName(String tagName) {
        return tagMapper.selectTagByName(tagName);
    }

    @Override
    public Tag findTagById(Long tagId) {
        return tagMapper.selectTagById(tagId);
    }


    private PageInfo<Tag> getPageInfo(PageRequest pageRequest,List<Tag> tags) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize,"tag_id");
        //List<Tag> tagMenus =tagMapper.listTagByPage();
        return new PageInfo<Tag>(tags);
    }
}
