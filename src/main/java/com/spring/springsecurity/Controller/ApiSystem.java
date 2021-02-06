package com.spring.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ApiSystem {

    @GetMapping("myadmin")
    public String admin(){
        return "i am admin";
    }

    @GetMapping("myadminmanget")
    public String adminOrManger(){
        return "i am admin || Manger";
    }

    @GetMapping("myadminmangeruser")
    public String adminOrMangerOrUser(){
        return "i am admin || Manger || User";
    }
}