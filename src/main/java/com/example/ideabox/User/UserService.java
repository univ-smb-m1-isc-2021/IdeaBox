package com.example.ideabox.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> users(){
        return userRepository.findAll();
    }

    public User findUserForConnection(String pseudo, String password){
        List<User> users = userRepository.findByPseudo(pseudo);
        String hashedpw = password; //TODO
        for(int i=0; i < users.size(); ++i){
            if(users.get(i).getHashpassword() == hashedpw){
                return users.get(i);
            }
        }
        return null;
    }

    @PostConstruct
    public void initialize(){
        this.userRepository.deleteAllInBatch();

        if (this.userRepository.findAll().isEmpty()){
            this.userRepository.saveAndFlush(
                    new User("email@email", "abcd123456", "RolanJeudeMotNul", "Rolan", "Garos")
            );
            this.userRepository.saveAndFlush(
                    new User("jeanmich@gmail.com", "oui", "JeanMich", "Jean", "Mich")
            );
        }
    }

}
