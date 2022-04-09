package com.example.ideabox.Campaign;


import com.example.ideabox.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("campaign")
public class CampaignController {


    private CampaignService campaignService;


    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }


    @GetMapping("/new")
    public String showNewCampaingForm(Model model, HttpServletRequest request){
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        return "campaign/new_campaign";
    }


    @PostMapping("/new")
    public String postNewCampaingForm(@ModelAttribute Campaign campaign, HttpServletRequest request){
        campaign.setUser( (User) request.getSession().getAttribute("user") );
        Campaign new_campaign = this.campaignService.create( campaign );
        return "redirect:/campaign/show/" + String.valueOf( new_campaign.getId() );
    }


    @GetMapping("/show/{campaignId}")
    public String showCampaign(@PathVariable(value = "campaignId") long id, Model model, HttpServletRequest request){
        model.addAttribute("campaign", this.campaignService.findById(id));
        return "campaign/show_campaign";
    }
}
