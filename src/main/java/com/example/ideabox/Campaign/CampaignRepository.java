package com.example.ideabox.Campaign;

import com.example.ideabox.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    Campaign findCampaignByName(String name);

    List<Campaign> findCampaignByUser(User user);

    Campaign findCampaignById(long id);

}
