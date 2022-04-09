package com.example.ideabox.User;


import com.example.ideabox.Application.ApplicationService;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
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
    private final ApplicationService applicationService;
    private final CampaignService campaignService;

    public UserController(UserService userService, ApplicationService applicationService,CampaignService campaignService){
        this.userService = userService;
        this.applicationService = applicationService;
        this.campaignService = campaignService;
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
        return "redirect:/user/profile";
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
        return "redirect:/user/profile";
    }

    @GetMapping("/disconnect")
    public String disconnect(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String showProfile(Model model,HttpServletRequest request){
        model.addAttribute("apps",applicationService.findApplicationByUser((User)request.getSession().getAttribute("user")));
        model.addAttribute("campaigns",campaignService.findCampaignByUser((User)request.getSession().getAttribute("user")));
        return "profile";
    }
}
