package com.example.myblog3.controller;

import com.example.myblog3.domain.Type;
import com.example.myblog3.service.TypeService;
import com.example.myblog3.util.PageRequest;
import com.example.myblog3.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/type")
public class AdminTypeController {
    @Autowired
    private TypeService typeService;
    //展示的页面，应该传入页码信息，初始化type和tag列表
    @GetMapping("/")
    public String showType(){

        return "admin/typeAndTag";
    }
    @ResponseBody
    @PostMapping("/getTypes")
    public PageResult getTypes(PageRequest pageRequest){
        return typeService.findTypeByPage(pageRequest);
    }

    @ResponseBody
    @GetMapping("/getTypes")
    public List<Type> getTypes(){
        return typeService.findAllType();
    }

    @GetMapping("/deleteType")
    public String deleteType(Type type){
        typeService.deleteType(type);
        return "admin/typeAndTag";
    }

    @PostMapping("addType")
    public String addType(Type type){
        typeService.addType(type);

        return "redirect:/admin/type/";
    }

    @PostMapping("saveType")
    public String saveType(@RequestBody Type type){
        System.out.println(type);
        if(type.getTypeId()!=null){
            typeService.updateType(type);
        }else{
            typeService.addType(type);
        }
        return "redirect:/admin/type/";
    }
    @PostMapping("/updateType")
    public String updateType(Type type){
        typeService.updateType(type);
        return "redirect:/admin/type/";
    }
}
