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
        List<Question> questionsPossibles = findQuestionByCampaign(campaign);
        Collections.shuffle(questionsPossibles);
        return questionsPossibles.get(0);
    }

    public void create(Question question){
        questionRepository.saveAndFlush(question);
    }
}
