package com.yassine.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Salle> salles;
}
