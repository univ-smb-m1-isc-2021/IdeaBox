package com.example.ideabox.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> users(){
        return userRepository.findAll();
    }

    public User findUserForConnection(String pseudo, String password){
        List<User> users = userRepository.findByPseudo(pseudo);
        for(int i=0; i < users.size(); ++i){
            if(passwordEncoder.matches(password,users.get(i).getHashpassword())){
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
                    new User("email@email", passwordEncoder.encode("123"), "RG", "Rolan", "Garos")
            );
            this.userRepository.saveAndFlush(
                    new User("jeanmich@gmail.com", passwordEncoder.encode("oui"), "JeanMich", "Jean", "Mich")
            );
        }
    }
}
