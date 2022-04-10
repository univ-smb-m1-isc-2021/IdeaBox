package com.example.ideabox;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Application.ApplicationService;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionClosed;
import com.example.ideabox.Question.QuestionOpen;
import com.example.ideabox.Question.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    private final ApplicationService applicationService;
    private final QuestionService questionService;

    public Api(ApplicationService applicationService, QuestionService questionService) {
        this.applicationService = applicationService;
        this.questionService = questionService;
    }

    @GetMapping("/api/{token}/getQuestion")
    public String getQuestion(@PathVariable String token){
        Application app = applicationService.findApplicationByToken(token);
        Campaign c = app.getCampaign();
        Question q = questionService.getAnyQuestionByCampaign(c);
        StringBuilder res = new StringBuilder()
                .append("<div id='ideabox'>")
                .append("<div id='ideabox-question'>")
                .append(q.getSentence())
                .append("</div>")
                .append("<div id='ideabox-answers'>");
        if(q instanceof QuestionClosed) {
            res.append("<input value='oui' name='ideabox-answer' type='radio'>")
                    .append("<label for='oui'>Oui</label>");
            if(((QuestionClosed) q).getAllowNeutral()) {
                res.append("<input value='peut-être' name='ideabox-answer' type='radio'>")
                        .append("<label for='oui'>Peut être</label>");
            }
            res.append("<input value='non' name='ideabox-answer' type='radio'>")
                    .append("<label for='oui'>Non</label>");
        }
        res.append("</div>")
                .append("<button id='ideabox-close'>")
                .append("Fermer")
                .append("</button>")
                .append("<button id='ideabox-validate'>")
                .append("Répondre")
                .append("</button>")
                .append("</div>");
        return res.toString();
    }
}
