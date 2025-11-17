package com.yassine.cinema.services;

import com.yassine.cinema.entities.Cinema;

import java.util.List;

public interface CinemaService {
    Cinema saveCinema(Cinema cinema);
    Cinema getCinema(Long id);
    List<Cinema> getAllCinemas();
    Cinema updateCinema(Long id, Cinema cinema);
    void deleteCinema(Long id);
}
