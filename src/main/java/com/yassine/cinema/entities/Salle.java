package com.yassine.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int capacite;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonIgnore
    private Cinema cinema;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Seance> seances;
}
