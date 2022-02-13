package com.example.ideabox.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers(){
        return List.of();
    }

    public User getUser(){
        return new User();
    }

    public boolean signIn(String name, String hashedPassword){
        return false;
    }

    public void signUp(String name, String company){
        User user = new User(name, company);
    }
}
