package com.yassine.cinema.services;

import com.yassine.cinema.entities.Film;
import com.yassine.cinema.repos.FilmRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film saveFilm(Film film) {
        if (film.getDuree() <= 0)
            throw new RuntimeException("La durée doit être > 0");
        return filmRepository.save(film);
    }

    @Override
    public Film getFilm(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film introuvable"));
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film updateFilm(Long id, Film film) {
        Film f = getFilm(id);
        f.setTitre(film.getTitre());
        f.setDuree(film.getDuree());
        f.setCategorie(film.getCategorie());
        f.setDescription(film.getDescription());
        return filmRepository.save(f);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
