package com.yassine.cinema.restcontrollers;

import com.yassine.cinema.entities.Film;
import com.yassine.cinema.services.FilmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
@CrossOrigin("*")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public Film add(@RequestBody Film film) {
        return filmService.saveFilm(film);
    }

    @GetMapping
    public List<Film> all() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable Long id) {
        return filmService.getFilm(id);
    }

    @PutMapping("/{id}")
    public Film update(@PathVariable Long id, @RequestBody Film film) {
        return filmService.updateFilm(id, film);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        filmService.deleteFilm(id);
    }
}
