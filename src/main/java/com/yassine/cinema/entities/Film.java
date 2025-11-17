package com.yassine.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private int duree;         // en minutes
    private String categorie;
    private String description;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Seance> seances;
}
