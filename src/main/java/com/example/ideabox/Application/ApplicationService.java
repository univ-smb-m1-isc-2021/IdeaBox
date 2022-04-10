package com.example.ideabox.Application;

import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.User.User;
import com.example.ideabox.User.UserRepository;
import com.example.ideabox.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

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

    public Application create(String name, User user, Campaign campaign){
        return this.create(
                new Application(
                        this.getNewAppToken(),
                        name, user, campaign
                )
        );
    }

    private String getNewAppToken(){
        String res = UUID.randomUUID().toString();
        while ( this.findApplicationByToken( res ) != null ){
            res = UUID.randomUUID().toString(); // pas bo mais ya plus l'temps
        }
        return res;
    }
}
