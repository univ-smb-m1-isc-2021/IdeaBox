package com.example.ideabox.Question;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class QuestionRange extends Question{

    @Column
    private float min = 0.0f;

    @Column
    private float max = 10.0f;

    @Column
    private float step = 1.0f;
}