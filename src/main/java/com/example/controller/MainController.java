package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 2726868668@qq.com
 * @date 2021/1/7 21:15
 * @desc
 */
@Controller
public class MainController {
    @PostMapping("/login")
    public String login(String username,String password){
        if(username!=null && password!=null &&
                username.equals("admin") && password.equals("admin"))
            return "/dashboard";
        return "redirect:/index.jsp?MSG=1";
    }
    @GetMapping("/home")
    public String home(String username,String password){
        return "/dashboard";
    }
}
