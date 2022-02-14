package com.example.ideabox.QuestionType;

import javax.persistence.*;

@Entity
@Table(name = "QuestionTypes")
public class QuestionType {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
}
