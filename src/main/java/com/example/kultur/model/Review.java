package com.example.kultur.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Set<User> userReview = new HashSet<>();

    private String text;
    private int rating;




    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Event event;

}
