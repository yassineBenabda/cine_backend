package com.yassine.cinema.repos;

import com.yassine.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {}
