package com.example.ideabox.Campaign;

import com.example.ideabox.Application.Application;
import com.example.ideabox.Application.ApplicationService;
import com.example.ideabox.User.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Campaign findCampaignByName(String name){
        return campaignRepository.findCampaignByName(name);
    }

    public List<Campaign> findCampaignByUser(User user){
        return campaignRepository.findCampaignByUser(user);
    }

    public void create(Campaign campaign){
        campaignRepository.saveAndFlush(campaign);
    }
}
