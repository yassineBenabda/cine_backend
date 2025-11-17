package com.yassine.cinema.restcontrollers;

import com.yassine.cinema.entities.Salle;
import com.yassine.cinema.services.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
@CrossOrigin("*")
public class SalleController {

    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @PostMapping("/{cinemaId}")
    public Salle add(@PathVariable Long cinemaId, @RequestBody Salle salle) {
        return salleService.saveSalle(salle, cinemaId);
    }

    @GetMapping
    public List<Salle> all() {
        return salleService.getAllSalles();
    }

    @GetMapping("/{id}")
    public Salle get(@PathVariable Long id) {
        return salleService.getSalle(id);
    }

    @PutMapping("/{id}")
    public Salle update(@PathVariable Long id, @RequestBody Salle salle) {
        return salleService.updateSalle(id, salle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        salleService.deleteSalle(id);
    }
}
