package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public DBInit(UserRepository userRepository,AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        /*this.userRepository.deleteAll();
        User admin = new User("ahmed",passwordEncoder.encode("ahmed123"),"20","alex",1);
        admin.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(admin);
        /////////////////////////////////////////////////////////////////////////
        User manger = new User("yaser",passwordEncoder.encode("yaser123"),"20","alex",1);
        Authorities mangerAuthorities1 = authoritiesRepository.findById(2L).get();
        Authorities mangerAuthorities2 = authoritiesRepository.findById(3L).get();
        Authorities mangerAuthorities3 = authoritiesRepository.findById(5L).get();
        Authorities mangerAuthorities4 = authoritiesRepository.findById(6L).get();
        manger.getAuthorities().add(mangerAuthorities1);
        manger.getAuthorities().add(mangerAuthorities2);
        manger.getAuthorities().add(mangerAuthorities3);
        manger.getAuthorities().add(mangerAuthorities4);
        userRepository.save(manger);
        /////////////////////////////////////////////////////////////////////////
        User user = new User("karim",passwordEncoder.encode("karim123"),"20","alex",1);
        Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
        Authorities userAuthorities2 = authoritiesRepository.findById(6L).get();
        user.getAuthorities().add(userAuthorities2);
        userRepository.save(user);*/
    }
}
