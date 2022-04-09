package com.example.ideabox.Campaign;

import com.example.ideabox.Application.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findCampaignByApp(Application app);

    Campaign findCampaignByName(String name);

    Campaign findCampaignById(long id);

}
