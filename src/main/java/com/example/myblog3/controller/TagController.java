package com.example.myblog3.controller;

import com.example.myblog3.service.BlogService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String tag(){
        return "tag";
    }
    @GetMapping("/{tagId}")
    @ResponseBody
    public PageResult getBlogsByTagId(@PathVariable Long tagId, PageRequest pageRequest){
        return blogService.listBlogsByTagId(tagId, pageRequest);
    }
}
