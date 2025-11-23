package com.yassine.cinema.restcontrollers;

import com.yassine.cinema.entities.Film;
import com.yassine.cinema.entities.Salle;
import com.yassine.cinema.entities.Seance;
import com.yassine.cinema.services.SeanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seances")
@CrossOrigin("*")
public class SeanceController {

    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping("/film/{filmId}")
    public List<Seance> getSeancesByFilm(@PathVariable Long filmId) {
        return seanceService.getSeancesByFilmId(filmId);
    }

    @PostMapping("/{filmId}/{salleId}")
    public Seance add(@PathVariable Long filmId,
                      @PathVariable Long salleId,
                      @RequestBody Seance seance) {
        return seanceService.saveSeance(seance, filmId, salleId);
    }

    @GetMapping
    public List<Seance> all() {
        return seanceService.getAllSeances();
    }

    @GetMapping("/{id}")
    public Seance get(@PathVariable Long id) {
        return seanceService.getSeance(id);
    }

    @PutMapping("/{id}")
    public Seance update(@PathVariable Long id, @RequestBody Seance seance) {
        return seanceService.updateSeance(id, seance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        seanceService.deleteSeance(id);
    }
}
