package com.example.ideabox.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("/logIn")
    public String showLogIn(){
        return "login";
    }

    @GetMapping("/signUp")
    public String showSignUp(){
        return "signup";
    }
}
