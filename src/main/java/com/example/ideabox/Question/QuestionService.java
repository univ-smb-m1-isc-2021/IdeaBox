package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;
import org.springframework.stereotype.Service;

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

    public void create(Question question){
        questionRepository.saveAndFlush(question);
    }
}
