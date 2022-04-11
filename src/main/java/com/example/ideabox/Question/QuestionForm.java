package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;

import java.util.ArrayList;

public class QuestionForm {

    private String sentence;

    private long campaignId;

    private boolean allowNeutral;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public boolean getAllowNeutral() {
        return allowNeutral;
    }

    public void setAllowNeutral(boolean allowNeutral) {
        this.allowNeutral = allowNeutral;
    }
}
