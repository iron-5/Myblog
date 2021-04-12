package com.example.myblog3.controller;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.service.BlogService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public String getBlogsByTagId(@PathVariable Long tagId, HttpSession session){
        session.setAttribute("tag",tagId);
        return "tag";
    }

    @PostMapping("/getBlogsByTagId")
    @ResponseBody
    public List<Blog> getBlogsByTagId(@RequestBody String[] tagID){
        if(tagID.length == 0) return null;
        List<Long> tags = new ArrayList<>();
        for (String tag:tagID
             ) {
            tags.add(Long.valueOf(tag));
        }
        return blogService.listBlogsByTags(tags);
    }
    //initBlog
    @GetMapping("/getBlogs")
    @ResponseBody
    public PageResult getBlogs(PageRequest pageRequest,
                               HttpSession session){
        Long tagId = (Long) session.getAttribute("tag");
        if(tagId == null){
           return blogService.findBlogByPage(pageRequest);
        }else{
            session.setAttribute("tag", null);
            return blogService.listBlogsByTagId(tagId,pageRequest);

        }

    }
}
