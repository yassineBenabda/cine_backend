package com.yassine.cinema.repos;

import com.yassine.cinema.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {}
