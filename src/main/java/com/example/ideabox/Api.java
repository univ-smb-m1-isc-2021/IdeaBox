package com.example.ideabox;

import com.example.ideabox.Answer.AnswerForm;
import com.example.ideabox.Answer.AnswerService;
import com.example.ideabox.Application.ApplicationService;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionClosed;
import com.example.ideabox.Question.QuestionForm;
import com.example.ideabox.Question.QuestionService;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.constant.Constable;

@RestController
public class Api {

    private final ApplicationService applicationService;
    private final CampaignService campaignService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public Api(ApplicationService applicationService, CampaignService campaignService, QuestionService questionService, AnswerService answerService) {
        this.applicationService = applicationService;
        this.campaignService = campaignService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/api/{token}/getQuestion")
    public String getQuestion(@PathVariable String token, @RequestParam(required = false, defaultValue = "", value="userId") String userId){
        Question q = questionService.getAnyQuestionByCampaign(applicationService.findApplicationByToken(token).getCampaign());
        if(q == null){
            return "";
        }
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
                .append("<button id='ideabox-close' onclick='closeIdeabox()'>")
                .append("Fermer")
                .append("</button>")
                .append("<button id='ideabox-validate' onclick='giveIdeaboxAnswer()'>")
                .append("Répondre")
                .append("</button>")
                .append("</div>")
                .append("<script>")
                .append("function closeIdeabox(){")
                .append("document.getElementById('ideabox').style.display = 'none';")
                .append("}")
                .append("function giveIdeaboxAnswer(){")
                .append("let xhr = new XMLHttpRequest();")
                .append("xhr.open('POST','/api/"+token+"/give-answer');")
                .append("xhr.setRequestHeader(\"Accept\", \"application/json\");")
                .append("xhr.setRequestHeader(\"Content-Type\", \"application/json\");")
                .append("let data = {")
                .append("'questionId':"+q.getId())
                .append(",'value' : document.querySelector('input[name=\"ideabox-answer\"]:checked').value");
        if(!userId.equals("")){
            res.append(",'userId':"+userId);
        }
        res.append("};")
                .append("xhr.send(JSON.stringify(data));")
                .append("closeIdeabox();")
                .append("}")
                .append("</script>");
        return res.toString();
    }

    @PostMapping("/api/{token}/give-answer")
    public String giveAnswer(@PathVariable String token,@RequestBody AnswerForm answerForm){
        System.out.println("\n\n\n\n\n\n"+answerForm.getUserId()+"\n\n\n\n\n\n");
        answerService.create(questionService.findQuestionById(answerForm.getQuestionId()),answerForm.getValue(),answerForm.getUserId());
        return "OK";
    }
}
