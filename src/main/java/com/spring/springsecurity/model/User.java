package com.spring.springsecurity.model;

import java.util.Set;

public class User {

    private Long id;

    private String userName;

    private String password;

    private String age;

    private String address;

    private int active;

    private Set<Role> roles;

    private Set<Authorities> authorities;



}
