package com.example.myblog3.controller;

import com.example.myblog3.domain.Tag;
import com.example.myblog3.service.TagService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/tag")
public class AdminTagController {
    @Autowired
    private TagService tagService;
    @RequestMapping("/")
    public String tags(){
        return "/admin/typeAndTag";
    }
    @ResponseBody
    @PostMapping("/getTags")
    public PageResult getTypes(@RequestBody PageRequest pageRequest){
        return tagService.findTagByPage(pageRequest);
    }

    @ResponseBody
    @GetMapping("/getTags")
    public List<Tag> getTypes(){
        return tagService.findAllTag();
    }

    @GetMapping("/deleteTag")
    public String deleteType(Tag tag){
        tagService.deleteTag(tag);
        return "redirect:/admin/tag/";
    }
    @PostMapping("addTag")
    public String addType(Tag tag){
        tagService.addTag(tag);

        return "redirect:/admin/tag/";
    }
    @PostMapping("/updateTag")
    public String updateType(Tag tag) {
        tagService.updateTag(tag);
        return "redirect:/admin/tag/";
    }
    @PostMapping("/savaTag")
    public String saveTag(@RequestBody Tag tag){
        if(tag.getTagId()==null){
            tagService.addTag(tag);
        }else{
            tagService.updateTag(tag);
        }
        return "/admin/typeAndTag";
    }

}
