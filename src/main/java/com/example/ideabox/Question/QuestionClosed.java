package com.example.ideabox.Question;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class QuestionClosed extends Question{

    @Column
    private boolean allowNeutral = false;
}
