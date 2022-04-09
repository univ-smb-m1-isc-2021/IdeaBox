package com.example.ideabox.Application;

import com.example.ideabox.User.User;
import com.example.ideabox.User.UserRepository;
import com.example.ideabox.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

//@Service
public class ApplicationService {/*

    private final ApplicationRepository applicationRepository;

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    public ApplicationService(ApplicationRepository applicationRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.applicationRepository = applicationRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Application> findApplicationByUser(User user){
        return applicationRepository.findApplicationByUser(user);
    }

    public Application findApplicationByToken(String token){
        return applicationRepository.findApplicationByToken(token);
    }

    @PostConstruct
    public void initialize(){

        if (this.applicationRepository.findAll().isEmpty()){
            this.applicationRepository.saveAndFlush(
                    new Application("token1","AppTest1",userService.findUserForConnection("JeanMich","oui"))
            );
            this.applicationRepository.saveAndFlush(
                    new Application("token2","AppTest2",userService.findUserForConnection("RG","123"))
            );
        }
    }*/
}
