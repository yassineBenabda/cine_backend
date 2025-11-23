package com.yassine.cinema.services;

import com.yassine.cinema.entities.Reservation;
import com.yassine.cinema.entities.Seance;
import com.yassine.cinema.repos.ReservationRepository;
import com.yassine.cinema.repos.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeanceRepository seanceRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, SeanceRepository seanceRepository) {
        this.reservationRepository = reservationRepository;
        this.seanceRepository = seanceRepository;
    }

    @Override
    public Reservation saveReservation(Long seanceId, Reservation reservation) {

        Seance seance = seanceRepository.findById(seanceId)
                .orElseThrow(() -> new RuntimeException("Séance introuvable"));

        int totalReserved = seance.getReservations()
                .stream()
                .mapToInt(Reservation::getNbPlaces)
                .sum();

        if (totalReserved + reservation.getNbPlaces() > seance.getSalle().getCapacite()) {
            throw new RuntimeException("Capacité de la salle dépassée");
        }

        reservation.setSeance(seance);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        Seance seance = existingReservation.getSeance();
        
        // Vérifier la capacité si le nombre de places change
        if (reservation.getNbPlaces() != existingReservation.getNbPlaces()) {
            int totalReserved = seance.getReservations()
                    .stream()
                    .filter(r -> !r.getId().equals(id))
                    .mapToInt(Reservation::getNbPlaces)
                    .sum();

            if (totalReserved + reservation.getNbPlaces() > seance.getSalle().getCapacite()) {
                throw new RuntimeException("Capacité de la salle dépassée");
            }
        }

        existingReservation.setClient(reservation.getClient());
        existingReservation.setNbPlaces(reservation.getNbPlaces());
        
        return reservationRepository.save(existingReservation);
    }

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
