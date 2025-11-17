package com.yassine.cinema.services;

import com.yassine.cinema.entities.Film;

import java.util.List;

public interface FilmService {
    Film saveFilm(Film film);
    Film getFilm(Long id);
    List<Film> getAllFilms();
    Film updateFilm(Long id, Film film);
    void deleteFilm(Long id);
}
