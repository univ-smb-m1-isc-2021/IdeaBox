package com.example.ideabox.Question;

import com.example.ideabox.Campaign.Campaign;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "question_type")
@Table(name = "Questions")
public abstract class Question {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Campaign campaign;

    @Column
    private String sentence;

    // A revoir
}
