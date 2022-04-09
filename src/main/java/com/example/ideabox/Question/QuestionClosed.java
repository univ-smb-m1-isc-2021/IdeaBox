package com.example.ideabox.Question;


import com.example.ideabox.Campaign.Campaign;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
public class QuestionClosed extends Question{

    @Column
    private boolean allowNeutral = false;

    public QuestionClosed(){}

    public QuestionClosed(Campaign campaign, String sentence, boolean allowNeutral){
        this.campaign = campaign;
        this.sentence = sentence;
        this.allowNeutral = allowNeutral;
    }

    public boolean getAllowNeutral() {
        return allowNeutral;
    }

    public void setAllowNeutral(boolean allowNeutral) {
        this.allowNeutral = allowNeutral;
    }
}
