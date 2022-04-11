package com.example.ideabox.Answer;

import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("answer")
public class AnswerController {

    private final AnswerService answerService;

    private final QuestionService questionService;

    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping("/{questionId}")
    public String getAnswers(@PathVariable long questionId, Model model){
        Question q = questionService.findQuestionById(questionId);
        Map<String,Integer> occurrences = answerService.getAnswersByQuestion(q);
        ArrayList<String> answers = new ArrayList<>(occurrences.keySet());
        model.addAttribute("question", q);
        model.addAttribute("answers", answers);
        model.addAttribute("occurrences", occurrences);
        System.out.println("\n\n\n\n\n\n\n\n\n"+occurrences+"\n\n\n\n\n\n\n\n\n");
        return "answer/show_answers";
    }
}
