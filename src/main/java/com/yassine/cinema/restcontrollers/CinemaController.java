package com.yassine.cinema.restcontrollers;

import com.yassine.cinema.entities.Cinema;
import com.yassine.cinema.services.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@CrossOrigin("*")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @PostMapping
    public Cinema add(@RequestBody Cinema cinema) {
        return cinemaService.saveCinema(cinema);
    }

    @GetMapping
    public List<Cinema> all() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/{id}")
    public Cinema get(@PathVariable Long id) {
        return cinemaService.getCinema(id);
    }

    @PutMapping("/{id}")
    public Cinema update(@PathVariable Long id, @RequestBody Cinema cinema) {
        return cinemaService.updateCinema(id, cinema);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
    }
}
