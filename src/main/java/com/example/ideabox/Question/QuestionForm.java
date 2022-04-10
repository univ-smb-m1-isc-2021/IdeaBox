package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;

import java.util.ArrayList;

public class QuestionForm {

    private String sentence;

    private ArrayList<Campaign> campaigns;

    private long campaignId;

    private String questionType;


    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public ArrayList<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(ArrayList<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
