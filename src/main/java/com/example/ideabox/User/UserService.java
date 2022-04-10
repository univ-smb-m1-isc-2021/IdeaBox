package com.example.ideabox.User;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ApplicationRepository applicationRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> users(){
        return userRepository.findAll();
    }

    public User findUserForConnection(String pseudo, String password){
        List<User> users = userRepository.findByPseudo(pseudo);
        for(int i=0; i < users.size(); ++i){
            if(passwordEncoder.matches(password,users.get(i).getHashpassword())){
                return users.get(i);
            }
        }
        return null;
    }

    public User findUserById(long id){
        return userRepository.findById(id);
    }

    public void create(String email, String password, String pseudo, String lastName, String firstName){
        this.userRepository.saveAndFlush(new User(email,passwordEncoder.encode(password),pseudo,lastName,firstName));
    }
}
