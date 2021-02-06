package com.spring.springsecurity.securityconfig.jwt;

import com.auth0.jwt.JWT;
import com.spring.springsecurity.model.JwtLogin;
import com.spring.springsecurity.model.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Service
public class MyJwtAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public MyJwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    public String generateToken(Authentication authResult) {

        //User principal = (User) authResult.getPrincipal();
        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
        System.out.println(principal.getUsername());
        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));
        return token;
    }
    public String login(JwtLogin jwtLogin) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtLogin.getUsername(),
                jwtLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = generateToken(authenticate);
        return token;
    }
}
