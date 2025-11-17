package com.yassine.cinema.services;

import com.yassine.cinema.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Long seanceId, Reservation reservation);
    Reservation getReservation(Long id);
    List<Reservation> getAllReservations();
    void deleteReservation(Long id);
}
