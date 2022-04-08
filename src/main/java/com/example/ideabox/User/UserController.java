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


    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLogIn(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String submitLogIn(@ModelAttribute LoginForm loginForm, Model model){
        System.out.println("\n\n\n\npseudo : "+loginForm.getPseudo()+"\n\n\n\n");
        User user = userService.findUserForConnection(loginForm.getPseudo(),loginForm.getPassword());
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        //Verif dans la bdd
        return "redirect:/profile";
    }

    @GetMapping("/signup")
    public String showSignUp(){
        return "signup";
    }
}
