package com.spring.springsecurity.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basic/")
public class BasicController {

    @GetMapping("/mybasic")
    public String login(){
        return "my name is Eslam";
    }

    @GetMapping("/allbasic")
    public String all(){
        return "I am happy";
    }
}
