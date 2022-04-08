package com.example.ideabox.Home;

import com.example.ideabox.User.User;
import com.example.ideabox.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String home(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            model.addAttribute("user",user);
        } else {
            model.addAttribute("users",userService.users());
        }
        return "home";
    }
}
