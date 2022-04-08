package com.example.ideabox.User;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


    @GetMapping("/login")
    public String showLogIn(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("password", new String());
        return "login";
    }

    @PostMapping("/login")
    public String submitLogIn(@ModelAttribute User user, @ModelAttribute String password, Model model){
        user.setHashpassword(password);
        model.addAttribute("user",user);
        //Verif dans la bdd
        return "home";
    }

    @GetMapping("/signup")
    public String showSignUp(){
        return "signup";
    }
}
