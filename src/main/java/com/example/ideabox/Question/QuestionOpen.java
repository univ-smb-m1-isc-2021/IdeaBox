package com.example.ideabox.Question;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class QuestionOpen extends Question{

    @Column
    private int charLimit = 255;
}