package com.example.ideabox.Home;

import com.example.ideabox.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("users",userService.users());
        return "home";
    }
}
