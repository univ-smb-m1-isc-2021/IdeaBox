package com.example.ideabox.Campaign;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Application.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

//@Service
public class CampaignService {/*
    private final CampaignRepository campaignRepository;

    private ApplicationService applicationService;

    public CampaignService(CampaignRepository campaignRepository, ApplicationService applicationService) {
        this.campaignRepository = campaignRepository;
        this.applicationService = applicationService;
    }

    public List<Campaign> findCampaignByApp(Application app){
        return campaignRepository.findCampaignByApp(app);
    }
    public Campaign findCampaignByName(String name){
        return campaignRepository.findCampaignByName(name);
    }

    @PostConstruct
    public void initialize(){
        this.campaignRepository.deleteAllInBatch();

        if (this.campaignRepository.findAll().isEmpty()){
            this.campaignRepository.saveAndFlush(
                    new Campaign("CampaignForAppTest1",applicationService.findApplicationByToken("token1"))
            );
            this.campaignRepository.saveAndFlush(
                    new Campaign("CampaignForAppTest2",applicationService.findApplicationByToken("token2"))
            );
        }
    }*/
}
