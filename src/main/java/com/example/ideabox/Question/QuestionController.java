package com.example.ideabox.Question;


import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("question")
public class QuestionController {


    private QuestionService questionService;
    private CampaignService campaignService;


    public QuestionController(QuestionService questionService, CampaignService campaignService) {
        this.questionService = questionService;
        this.campaignService = campaignService;
    }



    @GetMapping("/new")
    public String showNewQuestionForm(Model model, HttpServletRequest request){
        QuestionForm form = new QuestionForm();
        User user = (User) request.getSession().getAttribute("user");
        form.setCampaigns( (ArrayList<Campaign>) campaignService.findByUser( user ));
        model.addAttribute("form", form);
        return "question/new_question";
    }

    @PostMapping("/new")
    public String postNewQuestion(@ModelAttribute QuestionForm form, HttpServletRequest request){
        Campaign campaign = (Campaign) campaignService.findById( form.getCampaignId() );
        QuestionClosed question = new QuestionClosed( campaign, form.getSentence() );
        questionService.create( question );
        return "redirect:/campaign/show/" + String.valueOf( campaign.getId() );
    }
}
