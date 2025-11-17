package com.yassine.cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeure;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film film;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    @JsonIgnore
    private Salle salle;

    @OneToMany(mappedBy = "seance", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
