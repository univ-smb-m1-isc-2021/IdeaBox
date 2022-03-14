package com.example.ideabox.User;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{

    List<User> findByPseudo(String pseudo);

    Optional<User> findById(Long id);
}
