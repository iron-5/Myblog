package com.example.myblog3.controller;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.service.BlogService;
import com.example.myblog3.service.TypeService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    private BlogService blogService;
    @GetMapping
    public String type(){
        return "type";
    }
    @GetMapping("/{typeId}")
    @ResponseBody
    public PageResult getBlogsByTypeId(@PathVariable Long typeId, PageRequest pageRequest){
        return blogService.listBlogsByTagId(typeId, pageRequest);
    }

}
