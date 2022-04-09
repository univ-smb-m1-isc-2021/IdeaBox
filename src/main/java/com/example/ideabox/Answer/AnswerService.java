package com.example.ideabox.Answer;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAnswerByQuestion(Question question){
        return answerRepository.findAnswerByQuestion(question);
    }

    public void create(Answer answer){
        answerRepository.saveAndFlush(answer);
    }
}
