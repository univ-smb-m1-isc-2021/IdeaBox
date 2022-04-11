package com.example.ideabox.Question;

import com.example.ideabox.Answer.Answer;
import com.example.ideabox.Answer.AnswerRepository;
import com.example.ideabox.Answer.AnswerService;
import com.example.ideabox.Campaign.Campaign;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
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

    public Question getAnyQuestionByCampaignWithUser(Campaign campaign, String idUserForApp){
        if(campaign == null){
            return null;
        }
        List<Question> allQuestions = findQuestionByCampaign(campaign);
        System.out.println("\n\n\n\n\n\n"+allQuestions.size());
        List<Question> questionsNotPossible = answerService.getQuestionAnsweredByUser(idUserForApp);
        for(int i = 0; i<questionsNotPossible.size(); ++i){
            Iterator<Question> j = allQuestions.iterator();
            while(j.hasNext()){
                Question q = j.next();
                if(q.equals(questionsNotPossible.get(i))){
                    j.remove();
                }
            }
        }
        System.out.println(allQuestions.size()+"\n\n\n\n\n\n");
        if(allQuestions.isEmpty()){
            return null;
        }
        Collections.shuffle(allQuestions);
        return allQuestions.get(0);
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
