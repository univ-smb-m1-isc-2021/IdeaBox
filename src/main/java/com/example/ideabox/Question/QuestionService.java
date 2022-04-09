package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

//@Service
public class QuestionService {/*

    private final QuestionRepository questionRepository;

    private CampaignRepository campaignRepository;

    public QuestionService(QuestionRepository questionRepository, CampaignRepository campaignRepository) {
        this.questionRepository = questionRepository;
        this.campaignRepository = campaignRepository;
    }

    public List<Question> findQuestionByCampaign(Campaign campaign){
        return questionRepository.findQuestionByCampaign(campaign);
    }

    @PostConstruct
    public void initialize(){
        this.questionRepository.deleteAllInBatch();

        if (this.questionRepository.findAll().isEmpty()){
            this.questionRepository.saveAndFlush(
                    new QuestionClosed(campaignRepository.findCampaignByName("CampaignForAppTest1"),"Aimez-vous nos produits ?",true)
            );
            this.questionRepository.saveAndFlush(
                    new QuestionClosed(campaignRepository.findCampaignByName("CampaignForAppTest2"),"Notre gamme couvre t-elle vos exigeances ?",false)
            );
        }
    }*/
}
