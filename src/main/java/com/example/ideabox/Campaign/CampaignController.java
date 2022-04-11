package com.example.ideabox.Campaign;


import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionForm;
import com.example.ideabox.Question.QuestionService;
import com.example.ideabox.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("campaign")
public class CampaignController {


    private CampaignService campaignService;
    private QuestionService questionService;


    public CampaignController(CampaignService campaignService, QuestionService questionService) {
        this.campaignService = campaignService;
        this.questionService = questionService;
    }

    @PostMapping("/new")
    public String postNewCampaingForm(@ModelAttribute CampaignForm campaignForm, HttpServletRequest request){
        Campaign campaign = new Campaign(campaignForm.getName(),(User) request.getSession().getAttribute("user"));
        Campaign new_campaign = this.campaignService.create( campaign );
        return "redirect:/user/profile";
    }

    @GetMapping("/show/{campaignId}")
    public String showCampaign(@PathVariable(value = "campaignId") long id, Model model, HttpServletRequest request){
        Campaign campaign = this.campaignService.findById(id);
        ArrayList<Question> questions = (ArrayList<Question>) questionService.getQuestionByCampaign( campaign );
        QuestionForm qf = new QuestionForm();
        qf.setCampaignId(id);
        model.addAttribute("campaign", campaign);
        model.addAttribute("questions", questions);
        model.addAttribute("form", qf);
        return "campaign/show_campaign";
    }
}
