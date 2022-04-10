package com.example.ideabox.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserDataController {

    private final UserService userService;

    public UserDataController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/react/users")
    public List<User> users(){
        ArrayList<User> res = (ArrayList<User>) userService.users();
        return res;
    }

}
