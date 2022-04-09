package com.example.ideabox.Campaign;

import com.example.ideabox.Application.Application;
import com.example.ideabox.User.User;

import javax.persistence.*;

@Entity
@Table(name = "Campaigns")
public class Campaign {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToOne
    private Application app;

    public Campaign() {}

    public Campaign(String name, Application app) {
        this.name = name;
        this.app = app;
    }
}
