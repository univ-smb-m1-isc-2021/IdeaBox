package com.example.ideabox.Campaign;


import com.example.ideabox.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("campaign")
public class CampaignController {

    @GetMapping("/new")
    public String showNewCampaingForm(Model model, HttpServletRequest request){
        Campaign campaign = new Campaign();
        campaign.setUser( (User) request.getSession().getAttribute("user") );
        model.addAttribute("campaign", campaign);
        return "new_campaign";
    }

    @PostMapping("/new")
    public String postNewCampaingForm(@ModelAttribute Campaign campaign, HttpServletRequest request){
        
        return "redirect:/campaign/show";
    }
}
