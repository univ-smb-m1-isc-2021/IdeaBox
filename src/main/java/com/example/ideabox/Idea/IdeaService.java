package com.example.ideabox.Idea;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaService {

    public List<Idea> getAllIdeas(){
        return List.of();
    }

    public List<Idea> getAppIdeas(){
        return List.of();
    }

    public Idea getIdea(){
        return new Idea();
    }
}
