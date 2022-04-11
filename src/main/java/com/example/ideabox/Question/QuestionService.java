package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findQuestionByCampaign(Campaign campaign){
        return questionRepository.findQuestionByCampaign(campaign);
    }

    public Question getAnyQuestionByCampaign(Campaign campaign){
        if(campaign == null){
            return null;
        }
        List<Question> questionsPossibles = findQuestionByCampaign(campaign);
        if(questionsPossibles.isEmpty()){
            return null;
        }
        Collections.shuffle(questionsPossibles);
        return questionsPossibles.get(0);
    }

    public List<Question> findQuestionByCampaignButUserIdForApp(Campaign campaign, String userIdForApp){
        return questionRepository.findQuestionByCampaign(campaign);
    }

    public Question getAnyQuestionByCampaignButUserIdForApp(Campaign campaign, String userIdForApp) {
        List<Question> questionsPossibles = findQuestionByCampaignButUserIdForApp(campaign,userIdForApp);
        if(questionsPossibles.size() > 0){
            Collections.shuffle(questionsPossibles);
            return questionsPossibles.get(0);
        } else {
            return null;
        }
    }

    public Question findQuestionById(long id){
        return questionRepository.findQuestionById(id);
    }
    
    public List<Question> getQuestionByCampaign(Campaign campaign){
        return findQuestionByCampaign(campaign);
    }

    public Question create(Question question){
        return questionRepository.save(question);
    }

    public Question save(QuestionClosed q) {
        return questionRepository.save(q);
    }
}
