package com.example.kultur.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;


    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Band band;


}