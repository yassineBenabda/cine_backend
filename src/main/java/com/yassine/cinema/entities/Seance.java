package com.yassine.cinema.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getFilmId() {
        return (film != null) ? film.getId() : null;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getSalleId() {
        return (salle != null) ? salle.getId() : null;
    }

}
