package com.yassine.cinema.repos;

import com.yassine.cinema.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    List<Salle> findByCinemaId(Long cinemaId);
}
