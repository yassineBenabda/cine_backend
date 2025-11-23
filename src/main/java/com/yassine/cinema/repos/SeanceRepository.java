package com.yassine.cinema.repos;

import com.yassine.cinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByFilmId(Long filmId);
}
