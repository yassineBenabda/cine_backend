package com.yassine.cinema.services;

import com.yassine.cinema.entities.Seance;

import java.util.List;

public interface SeanceService {
    Seance saveSeance(Seance seance, Long filmId, Long salleId);
    Seance getSeance(Long id);
    List<Seance> getAllSeances();
    Seance updateSeance(Long id, Seance seance);
    void deleteSeance(Long id);
}
