package com.example.ideabox.Idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "idea/")
public class IdeaController {

    private IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping(value = "allIdeas")
    public List<Idea> getAllIdeas(){
        return this.ideaService.getAllIdeas();
    }

    @GetMapping(value = "app")
    public List<Idea> getAppIdeas(){
        return this.ideaService.getAppIdeas();
    }

    @GetMapping(value = "idea")
    public Idea getIdea(){
        return this.ideaService.getIdea();
    }
}
