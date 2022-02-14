package com.example.ideabox.Application;

import com.example.ideabox.Campaign.Campaign;

import javax.persistence.*;

@Entity
@Table(name = "Applications")
public class Application {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private long token;

    @Column
    private String name;

    @OneToOne
    private Campaign campaign;

}
