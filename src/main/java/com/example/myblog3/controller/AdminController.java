package com.example.myblog3.controller;

import com.example.myblog3.domain.User;
import com.example.myblog3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    //转入测试页面
    @GetMapping("/")
    public String index(){
        return "admin/login";
    }
    //登录验证
    @PostMapping("/login")
    public String login(String nickname, String password,
                        HttpSession session, HttpServletRequest request){
        User user = userService.findUser(nickname, password);
        if(user != null){
            session.setAttribute("user", user);
            return "blogManage";
        }else{
            request.setAttribute("err", "用户名/密码错误，请重新输入！");
            return "admin/login";
        }
    }
    //发布页面
    @GetMapping("/publish")
    public String publish(){
        return "/admin/publish";
    }
    @RequestMapping("/logout")
    public String logout(){

        return "redirect:/admin/login";
    }

}
