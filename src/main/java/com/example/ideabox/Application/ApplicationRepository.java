package com.example.ideabox.Application;

import com.example.ideabox.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findApplicationByUser(User user);

    Application findApplicationByToken(String token);

    Application findApplicationById(long id);

}
