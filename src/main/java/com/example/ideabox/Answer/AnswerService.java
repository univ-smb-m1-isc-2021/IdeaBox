package com.example.ideabox.Answer;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignService;
import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAnswerByQuestion(Question question){
        return answerRepository.findAnswerByQuestion(question);
    }

    public Map<String,Integer> getAnswersByQuestion(Question question){
        Map<String, Integer> dict = new HashMap<>();
        ArrayList<Answer> answers = (ArrayList<Answer>) findAnswerByQuestion(question);
        for(int i = 0; i < answers.size(); ++i){
            String key = answers.get(i).getValue();
            dict.putIfAbsent(key,0);
            dict.put(key, dict.get(key)+1);
        }
        return dict;
    }

    public void create(Question question, String value, String userIdForApp){
        answerRepository.saveAndFlush(new Answer(question,value,userIdForApp));
    }
}
