package com.example.ideabox.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void initialize(){
        this.userRepository.deleteAllInBatch();

        if (this.userRepository.findAll().isEmpty()){
            this.userRepository.saveAndFlush(
                    new User("email@email", "abcd123456", "RolanJeudeMotNul", "Rolan", "Garos")
            );
        }
    }

}
