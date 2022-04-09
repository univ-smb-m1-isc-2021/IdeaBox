package com.example.ideabox;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Application.ApplicationRepository;
import com.example.ideabox.Application.ApplicationService;
import com.example.ideabox.User.User;
import com.example.ideabox.User.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Initializer {
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;

    private PasswordEncoder passwordEncoder;

    public Initializer(UserRepository userRepository, ApplicationRepository applicationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initialize(){
        applicationRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        User rg = new User("email@email", passwordEncoder.encode("123"), "RG", "Rolan", "Garos");
        User jeanmich = new User("jeanmich@gmail.com", passwordEncoder.encode("oui"), "JeanMich", "Jean", "Mich");

        Application appTest1 = new Application("token1","AppTest1",rg);
        Application appTest2 = new Application("token2","AppTest2",jeanmich);

        if(userRepository.findAll().isEmpty()){
            userRepository.saveAndFlush(rg);
            userRepository.saveAndFlush(jeanmich);
        }
        if(applicationRepository.findAll().isEmpty()){
            applicationRepository.saveAndFlush(appTest1);
            applicationRepository.saveAndFlush(appTest2);
        }
    }
}
