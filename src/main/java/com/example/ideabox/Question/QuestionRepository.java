package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long> {
    List<Question> findQuestionByCampaign(Campaign campaign);

    Question findQuestionById(long id);
}
