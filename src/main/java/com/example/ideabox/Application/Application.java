package com.example.ideabox.Application;

import com.example.ideabox.Campaign.Campaign;
import com.example.ideabox.User.User;
import io.micrometer.core.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "Applications")
public class Application {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String token;

    @Column
    private String name;

    @ManyToOne
    private User user;

    @ManyToOne
    private Campaign campaign;

    public Application(){}

    public Application(String token, String name, User user) {
        this.token = token;
        this.name = name;
        this.user = user;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
