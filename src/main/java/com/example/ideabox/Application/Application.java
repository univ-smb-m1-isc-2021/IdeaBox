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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String token;

    @Column
    private String name;

    @ManyToOne
    private User user;

    @ManyToOne
    private Campaign campaign;

    public Application(){}

    public Application(String token, String name, User user, Campaign campaign) {
        this.token = token;
        this.name = name;
        this.user = user;
        this.campaign = campaign;
    }

    public Application(String name, User user, Campaign campaign) {
        this.name = name;
        this.user = user;
        this.campaign = campaign;
    }

    public Application(String token, String name, User user) {
        this.token = token;
        this.name = name;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }


    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", campaign=" + campaign +
                '}';
    }
}
