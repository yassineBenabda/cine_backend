package com.yassine.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String client;
    private int nbPlaces;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    @JsonIgnore
    private Seance seance;
}
