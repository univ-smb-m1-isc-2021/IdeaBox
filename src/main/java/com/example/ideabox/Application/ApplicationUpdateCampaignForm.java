package com.example.ideabox.Application;

public class ApplicationUpdateCampaignForm {
    private long appId;
    private long campaignId;

    public ApplicationUpdateCampaignForm(long appId, long campaignId) {
        this.appId = appId;
        this.campaignId = campaignId;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }
}
