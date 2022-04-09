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

    public Campaign() {}

    public Campaign(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
