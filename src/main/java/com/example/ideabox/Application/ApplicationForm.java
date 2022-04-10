package com.example.ideabox.Application;

import com.example.ideabox.Campaign.Campaign;

import java.util.ArrayList;

public class ApplicationForm {


    private String name;
    private long campaignChoisie;
    private ArrayList<Campaign> mesCampagnes;



    public ApplicationForm() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCampaignChoisie() {
        return campaignChoisie;
    }

    public void setCampaignChoisie(long campaignChoisie) {
        this.campaignChoisie = campaignChoisie;
    }

    public ArrayList<Campaign> getMesCampagnes() {
        return mesCampagnes;
    }

    public void setMesCampagnes(ArrayList<Campaign> mesCampagnes) {
        this.mesCampagnes = mesCampagnes;
    }
}
