package com.spring.springsecurity.Controller;


import com.spring.springsecurity.model.JwtLogin;
import com.spring.springsecurity.securityconfig.jwt.MyJwtAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/")
public class Main {

    private MyJwtAuthenticationFilter myJwtAuthenticationFilter;

    public Main(MyJwtAuthenticationFilter myJwtAuthenticationFilter) {
        this.myJwtAuthenticationFilter = myJwtAuthenticationFilter;
    }
    @GetMapping("all")
    public String admin(){
        return "i am all";
    }

    @PostMapping("signin")
    public String signin(@RequestBody JwtLogin jwtLogin){
        return this.myJwtAuthenticationFilter.login(jwtLogin);
    }
}
