package com.yassine.cinema.repos;

import com.yassine.cinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {}
