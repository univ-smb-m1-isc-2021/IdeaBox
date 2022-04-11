package com.example.ideabox.Application;


import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("app")
public class ApplicationController {

    private ApplicationService applicationService;
    private CampaignService campaignService;


    public ApplicationController(ApplicationService applicationService, CampaignService campaignService) {
        this.applicationService = applicationService;
        this.campaignService = campaignService;
    }

    @GetMapping("/new")
    public String showNewAppForm(Model model, HttpServletRequest request){
        ApplicationForm form = new ApplicationForm();
        form.setMesCampagnes( (ArrayList<Campaign>) campaignService.findByUser( (User) request.getSession().getAttribute("user") ) );

        model.addAttribute("form", form);

        return "application/new_application";
    }


    @PostMapping("/new")
    public String postNewApp(@ModelAttribute ApplicationForm form, HttpServletRequest request){

        Application new_app = applicationService.create(
                form.getName(),
                (User) request.getSession().getAttribute("user"),
                (Campaign) campaignService.findById( form.getCampaignChoisie() )
                );
        return "redirect:/user/profile";
    }

    @PostMapping("/update-campaign")
    public String updateCampaign(@RequestBody ApplicationUpdateCampaignForm updateForm){
        Application app = applicationService.findApplicationById(updateForm.getAppId());
        if(updateForm.getCampaignId() == 0){
            app.setCampaign(null);
        } else {
            app.setCampaign(campaignService.findById(updateForm.getCampaignId()));
        }
        applicationService.save(app);
        return "redirect:/user/profile";
    }
}
