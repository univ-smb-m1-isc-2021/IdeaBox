package com.example.ideabox.User;

import com.example.ideabox.InitialHtml;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserReactController {

    @GetMapping("/react")
    public String renderMainPage(){
        return new InitialHtml("Users").serialize();
    }
}
