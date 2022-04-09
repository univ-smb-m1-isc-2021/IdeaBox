package com.example.ideabox.Campaign;

import com.example.ideabox.Application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findCampaignByApp(Application app);

    Campaign findCampaignByName(String name);

    Campaign findCampaignById(long id);

}
