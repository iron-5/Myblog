package com.example.myblog3.controller;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String blog(){
        return "blogs";
    }

    @GetMapping("/content/{id}")
    public String getContent(@PathVariable Long id, HttpSession session){
        session.setAttribute("blogId", id);
        return "content";
    }
    @ResponseBody
    @GetMapping("/getContent")
    public Blog getContent(HttpSession session){
        Long id = (Long) session.getAttribute("blogId");
        return blogService.getBlogById(id);
    }

}
