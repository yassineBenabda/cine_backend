package com.yassine.cinema.services;

import com.yassine.cinema.entities.Salle;

import java.util.List;

public interface SalleService {
    Salle saveSalle(Salle salle, Long cinemaId);
    Salle getSalle(Long id);
    List<Salle> getSallesByCinema(Long cinemaId);
    List<Salle> getAllSalles();
    Salle updateSalle(Long id, Salle salle);
    void deleteSalle(Long id);
}
