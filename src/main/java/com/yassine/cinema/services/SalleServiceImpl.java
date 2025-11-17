package com.yassine.cinema.services;

import com.yassine.cinema.entities.Cinema;
import com.yassine.cinema.entities.Salle;
import com.yassine.cinema.repos.CinemaRepository;
import com.yassine.cinema.repos.SalleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;
    private final CinemaRepository cinemaRepository;

    public SalleServiceImpl(SalleRepository salleRepository, CinemaRepository cinemaRepository) {
        this.salleRepository = salleRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Salle saveSalle(Salle salle, Long cinemaId) {
        if (salle.getCapacite() <= 0)
            throw new RuntimeException("La capacité de la salle doit être > 0");

        Cinema cinema = cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new RuntimeException("Cinéma introuvable"));

        salle.setCinema(cinema);
        return salleRepository.save(salle);
    }

    @Override
    public Salle getSalle(Long id) {
        return salleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salle introuvable"));
    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    @Override
    public Salle updateSalle(Long id, Salle salle) {
        Salle s = getSalle(id);
        s.setNom(salle.getNom());
        s.setCapacite(salle.getCapacite());
        return salleRepository.save(s);
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}
