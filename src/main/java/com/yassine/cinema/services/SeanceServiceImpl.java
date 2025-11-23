package com.yassine.cinema.services;

import com.yassine.cinema.entities.Film;
import com.yassine.cinema.entities.Salle;
import com.yassine.cinema.entities.Seance;
import com.yassine.cinema.repos.FilmRepository;
import com.yassine.cinema.repos.SalleRepository;
import com.yassine.cinema.repos.SeanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final FilmRepository filmRepository;
    private final SalleRepository salleRepository;

    public SeanceServiceImpl(SeanceRepository seanceRepository, FilmRepository filmRepository, SalleRepository salleRepository) {
        this.seanceRepository = seanceRepository;
        this.filmRepository = filmRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public Seance saveSeance(Seance seance, Long filmId, Long salleId) {

        if (seance.getDateHeure().isBefore(LocalDateTime.now().plusMinutes(1))) {
            throw new RuntimeException("La séance doit être au moins 1 minute dans le futur");
        }

        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film introuvable"));

        Salle salle = salleRepository.findById(salleId)
                .orElseThrow(() -> new RuntimeException("Salle introuvable"));

        seance.setFilm(film);
        seance.setSalle(salle);

        return seanceRepository.save(seance);
    }

    @Override
    public Seance getSeance(Long id) {
        return seanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Séance introuvable"));
    }

    @Override
    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance updateSeance(Long id, Seance seance) {
        Seance s = getSeance(id);
        s.setDateHeure(seance.getDateHeure());
        return seanceRepository.save(s);
    }

    @Override
    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }
    public List<Seance> getSeancesByFilmId(Long filmId) {
        return seanceRepository.findByFilmId(filmId);
    }
}
