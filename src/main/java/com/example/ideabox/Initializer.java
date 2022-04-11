package com.example.ideabox;

import com.example.ideabox.Answer.Answer;
import com.example.ideabox.Answer.AnswerRepository;
import com.example.ideabox.Application.Application;
import com.example.ideabox.Application.ApplicationRepository;
import com.example.ideabox.Application.ApplicationService;
import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.Campaign.CampaignRepository;
import com.example.ideabox.Question.Question;
import com.example.ideabox.Question.QuestionClosed;
import com.example.ideabox.Question.QuestionRepository;
import com.example.ideabox.User.User;
import com.example.ideabox.User.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Initializer {
    private final UserRepository userRepository;
    private final ApplicationRepository applicationRepository;
    private final CampaignRepository campaignRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    private PasswordEncoder passwordEncoder;

    public Initializer(UserRepository userRepository, ApplicationRepository applicationRepository, CampaignRepository campaignRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.applicationRepository = applicationRepository;
        this.campaignRepository = campaignRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initialize(){
        answerRepository.deleteAllInBatch();
        questionRepository.deleteAllInBatch();
        applicationRepository.deleteAllInBatch();
        campaignRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        User rg = new User("ideabox@gmail.com", passwordEncoder.encode("App2Fou"), "IdeaBox", "Idea", "Box");
        User jeanmich = new User("jeanmich@gmail.com", passwordEncoder.encode("oui"), "JeanMich", "Jean", "Mich");

        Campaign c1 = new Campaign("PotentialUsers",rg);
        Campaign c2 = new Campaign("CampaignForAppTest2",jeanmich);

        Application appTest1 = new Application("TokenIdeaBox","IdeaBox",rg,c1);
        Application appTest2 = new Application("token2","AppTest2",jeanmich,c2);

        Question q1 = new QuestionClosed(c1,"Comptez-vous utiliser notre produit ?",true);
        Question q2 = new QuestionClosed(c2,"Aimez-vous le chocolat ?",true);
        Question q3 = new QuestionClosed(c2,"Notre gamme couvre t-elle vos exigeances ?",false);

        Answer a1 = new Answer(q1,"oui",null);
        Answer a2 = new Answer(q2,"non",null);

        if(userRepository.findAll().isEmpty()){
            userRepository.saveAndFlush(rg);
            userRepository.saveAndFlush(jeanmich);
        }
        if(campaignRepository.findAll().isEmpty()){
            campaignRepository.saveAndFlush(c1);
            campaignRepository.saveAndFlush(c2);
        }
        if(applicationRepository.findAll().isEmpty()){
            applicationRepository.saveAndFlush(appTest1);
            applicationRepository.saveAndFlush(appTest2);
        }
        if(questionRepository.findAll().isEmpty()){
            questionRepository.saveAndFlush(q1);
            questionRepository.saveAndFlush(q2);
            questionRepository.saveAndFlush(q3);
        }
        if(answerRepository.findAll().isEmpty()){
            answerRepository.saveAndFlush(a1);
            answerRepository.saveAndFlush(a2);
        }
    }
}
