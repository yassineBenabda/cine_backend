package com.yassine.cinema.repos;

import com.yassine.cinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    @Query("SELECT s FROM Seance s WHERE s.film.id = :filmId")
    List<Seance> findByFilmId(@Param("filmId") Long filmId);

}
