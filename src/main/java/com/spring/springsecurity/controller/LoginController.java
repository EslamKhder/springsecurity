package com.spring.springsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
public class LoginController {
    @GetMapping("login")
    public String login(){
        return "login";
    }

}
