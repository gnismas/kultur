package com.example.kultur.model;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data // laver getter, setter, toString(), hashCode()
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "userReview")
    private Set<Review> reviews = new HashSet<>();
}