package com.example.myblog3.controller;

import com.example.myblog3.domain.Blog;
import com.example.myblog3.service.BlogService;
import com.example.myblog3.service.TypeService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @GetMapping
    public String type(){
        return "type";
    }

    @PostMapping("/{typeId}")
    @ResponseBody
    public PageResult getBlogsByTypeId(@PathVariable String typeId,
                                       @RequestBody PageRequest pageRequest){
        Long id = Long.valueOf(typeId);
        return blogService.listBlogsByTypeId(id, pageRequest);
    }
    @GetMapping("/getBlogs")
    public String getBlogs(Long typeId, HttpSession session){
        session.setAttribute("typeId",typeId);
        return "type";
    }

    @ResponseBody
    @PostMapping("/getBlogsByTypeId")
    public PageResult getBlogsByPage(@RequestBody PageRequest pageRequest,HttpSession session){
            PageResult result = null;
            System.out.println(pageRequest);

            Long typeId = (Long)session.getAttribute("typeId");
            if(typeId == null){
                result = blogService.findBlogByPage(pageRequest);
            }else {
                System.out.println("========");
                result = blogService.listBlogsByTypeId(typeId,pageRequest);
                session.setAttribute("typeId",null);
            }

        return result;
    }
}
