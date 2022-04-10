package com.example.ideabox.Answer;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Question.Question;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Question question;

    @Column
    private String userIdForApp;

    @Column
    private String value;

    public Answer(){}

    public Answer(Question question, String value, String userIdForApp) {
        this.question = question;
        this.value = value;
        this.userIdForApp = userIdForApp;
    }
}
