package com.example.ideabox.Answer;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

//@Service
public class AnswerService {/*
    private final AnswerRepository answerRepository;

    private QuestionService questionService;

    private CampaignService campaignService;

    public AnswerService(AnswerRepository answerRepository, QuestionService questionService, CampaignService campaignService) {
        this.answerRepository = answerRepository;
        this.questionService = questionService;
        this.campaignService = campaignService;
    }

    public List<Answer> findAnswerByQuestion(Question question){
        return answerRepository.findAnswerByQuestion(question);
    }

    @PostConstruct
    public void initialize(){
        this.answerRepository.deleteAllInBatch();

        if (this.answerRepository.findAll().isEmpty()){
            this.answerRepository.saveAndFlush(
                    new Answer(questionService.findQuestionByCampaign(campaignService.findCampaignByName("CampaignForAppTest1")).get(0),"non")
            );
            this.answerRepository.saveAndFlush(
                    new Answer(questionService.findQuestionByCampaign(campaignService.findCampaignByName("CampaignForAppTest2")).get(0),"oui")
            );
        }
    }
*/}
