package com.spring.springsecurity.service;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.springsecurity.dto.ResponseLogin;
import com.spring.springsecurity.model.JwtLogin;
import com.spring.springsecurity.model.UserPrincipal;
import com.spring.springsecurity.securityconfig.jwt.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Service
public class TokenService {

    private AuthenticationManager authenticationManager;

    @Autowired
    public TokenService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Authentication attemptAuthentication(JwtLogin jwtLogin) throws AuthenticationException {

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtLogin.getUsername(),
                jwtLogin.getPassword(),
                new ArrayList<>());

        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        return auth;
    }

    public ResponseLogin successfulAuthentication(JwtLogin jwtLogin) throws Exception {
        ResponseLogin responseLogin  = new ResponseLogin();
        Authentication authResult = attemptAuthentication(jwtLogin);

        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        responseLogin.setUsername(jwtLogin.getUsername());

        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        responseLogin.setToken(token);
        return responseLogin;
    }
}
