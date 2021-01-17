package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.RoleRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.Role;
import com.spring.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public DBInit(UserRepository userRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        User admin = new User("ahmed","ahmed123","20","alex",1);
        admin.setRoles(this.roleRepository.findAll());
        admin.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(admin);
        /////////////////////////////////////////////////////////////////////////
        User manger = new User("yaser","yaser123","20","alex",1);
        Role mangerRoles1 = roleRepository.findById(2L).get();
        System.out.println(mangerRoles1.getId());
        Role mangerRoles2 = roleRepository.findById(3L).get();
        Authorities mangerAuthorities1 = authoritiesRepository.findById(2L).get();
        Authorities mangerAuthorities2 = authoritiesRepository.findById(3L).get();
        manger.getRoles().add(mangerRoles1);
        manger.getRoles().add(mangerRoles2);
        manger.getAuthorities().add(mangerAuthorities1);
        manger.getAuthorities().add(mangerAuthorities2);
        userRepository.save(manger);
        /////////////////////////////////////////////////////////////////////////
        User user = new User("karim","karim123","20","alex",1);
        Role userRoles1 = roleRepository.findById(3L).get();
        Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
        user.getRoles().add(userRoles1);
        user.getAuthorities().add(userAuthorities1);
        userRepository.save(user);
    }
}
