package com.example.ideabox.User;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String submitLogIn(@ModelAttribute LoginForm loginForm, Model model, HttpServletRequest request){
        System.out.println("\n\n\n\npseudo : "+loginForm.getPseudo()+"\n\n\n\n");
        User user = userService.findUserForConnection(loginForm.getPseudo(),loginForm.getPassword());
        if(user == null){
            model.addAttribute("erreur",true);
            model.addAttribute("loginForm",new LoginForm());
            return "login";
        }
        request.getSession().setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUp(Model model){
        model.addAttribute("signupForm",new SignupForm());
        return "signup";
    }

    @PostMapping("/signup")
    public String showSignUp(@ModelAttribute SignupForm signupForm, Model model, HttpServletRequest request){
        if(!signupForm.getPassword().equals(signupForm.getConfirmPassword())){
            model.addAttribute("erreur",true);
            model.addAttribute("signupForm",signupForm);
            return "signup";
        }
        userService.create(signupForm.getEmail(),signupForm.getPassword(),signupForm.getPseudo(),signupForm.getLastName(),signupForm.getFirstName());
        User user = userService.findUserForConnection(signupForm.getPseudo(),signupForm.getPassword());
        if(user == null){
            model.addAttribute("erreur",true);
            model.addAttribute("signupForm",signupForm);
            return "signup";
        }
        request.getSession().setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/deconnect")
    public String disconnect(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }
}
