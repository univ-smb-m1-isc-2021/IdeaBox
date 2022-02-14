package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.QuestionType.QuestionType;

import javax.persistence.*;

@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private Campaign campaign;

    @OneToMany
    private QuestionType questionType;

    // A revoir
}
