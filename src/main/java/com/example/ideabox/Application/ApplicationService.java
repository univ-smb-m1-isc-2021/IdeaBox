package com.example.ideabox.Application;

import com.example.ideabox.User.User;
import com.example.ideabox.User.UserRepository;
import com.example.ideabox.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> findApplicationByUser(User user){
        return applicationRepository.findApplicationByUser(user);
    }

    public Application findApplicationByToken(String token){
        return applicationRepository.findApplicationByToken(token);
    }

    public Application findById(long id){ return applicationRepository.findApplicationById(id); }

    public Application create(Application app){
        return this.applicationRepository.save(app);
    }
}
