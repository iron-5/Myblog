package com.example.myblog3.controller;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.domain.Tag;
import com.example.myblog3.domain.User;
import com.example.myblog3.service.BlogService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/blog")
public class AdminBlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/")
    public String blog(){
        return "/admin/blogManage";
    }

    @ResponseBody
    @GetMapping("/getBlogs")
    public PageResult getBlogs(PageRequest pageRequest){
        return blogService.findBlogByPage(pageRequest);
    }
    @PostMapping("/search")
    public String search(PageRequest pageRequest,String content,HttpSession session){
        session.setAttribute("pageRequest", pageRequest);
        session.setAttribute("content", content);
        return "result";
    }
    @ResponseBody
    @PostMapping("/searchBlog")
    public PageResult searchBlogResult(HttpSession session){
        PageRequest pageRequest = (PageRequest) session.getAttribute("pageRequest");
        String content = (String) session.getAttribute("content");
        PageResult pageResult = blogService.searchBlogs(pageRequest, null, null ,content);
        return pageResult;
    }

    @PostMapping("/delete")
    public void delete(@RequestPart Blog blog){
        blogService.removeBlog(blog);
    }

    @GetMapping("/publish")
    public String publish(){
        return "admin/publish";
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody Blog blog, HttpSession session){
       // System.out.println(blog);
        Blog b = blogService.getBlogById(blog.getBlogId());
        session.setAttribute("blog", b);

        return "/admin/publish";
    }

    @ResponseBody
    @GetMapping("/getBlog")
    public Blog getBlog(HttpSession session){
        Blog blog = (Blog)session.getAttribute("blog");
        return blog;
    }

    @PostMapping("/save")
    private String saveBlog(Blog blog,HttpSession session){

        if(blog.getBlogId()!=null){
            Blog oldBlog = blogService.getBlogById(blog.getBlogId());
            blogService.updateBlog(oldBlog,blog);
        }else{
            User user = new User();
            user.setUserId(Long.valueOf(1));
            blogService.addBlog(blog,user);
        }
        return "admin/publish";
    }
    private void clearSession(HttpSession session){
        session.removeAttribute("blog");
    }
}
