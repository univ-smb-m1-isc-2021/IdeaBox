package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
@Table(name = "questions")
public abstract class Question {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    protected Campaign campaign;

    @Column
    protected String sentence;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
