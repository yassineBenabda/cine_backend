package com.yassine.cinema.services;

import com.yassine.cinema.entities.Cinema;
import com.yassine.cinema.repos.CinemaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema getCinema(Long id) {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema introuvable"));
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema updateCinema(Long id, Cinema cinema) {
        Cinema c = getCinema(id);
        c.setNom(cinema.getNom());
        c.setAdresse(cinema.getAdresse());
        return cinemaRepository.save(c);
    }

    @Override
    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}
