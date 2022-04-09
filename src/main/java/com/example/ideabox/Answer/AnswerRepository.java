package com.example.ideabox.Answer;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findAnswerByQuestion(Question question);

    Answer findAnswerById(long id);
}
