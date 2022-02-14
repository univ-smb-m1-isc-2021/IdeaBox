package com.example.ideabox.User;
import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column
    private String pseudo;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String nom;
}
