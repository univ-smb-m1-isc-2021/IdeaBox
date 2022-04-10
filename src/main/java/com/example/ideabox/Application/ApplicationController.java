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
        Application application = new Application(
                form.getName(),
                (User) request.getSession().getAttribute("user"),
                (Campaign) campaignService.findById( form.getCampaignChoisie() )
        );

        Application new_app = applicationService.create(application);
        return "redirect:/app/show/" + String.valueOf( new_app.getId() );
    }


    @GetMapping("/show/{appId}")
    public String showApp(@PathVariable(value = "appId") long id, Model model, HttpServletRequest request){
        model.addAttribute( "app", applicationService.findById( id ) );
        return "application/show_application";
    }
}
