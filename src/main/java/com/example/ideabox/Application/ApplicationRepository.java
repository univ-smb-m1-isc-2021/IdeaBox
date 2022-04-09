package com.example.ideabox.Application;

import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findApplicationByUser(User user);

    List<Application> findApplicationByCampaign(Campaign campaign);

    Application findApplicationByToken(String token);

    Application findApplicationById(long id);

}
