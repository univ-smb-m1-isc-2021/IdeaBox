package com.example.ideabox.Answer;

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
    private String idFromApp;

    @Column
    private String value;
}
