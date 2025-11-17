package com.yassine.cinema.restcontrollers;

import com.yassine.cinema.entities.Reservation;
import com.yassine.cinema.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin("*")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/{seanceId}")
    public Reservation add(@PathVariable Long seanceId,
                           @RequestBody Reservation reservation) {
        return reservationService.saveReservation(seanceId, reservation);
    }

    @GetMapping
    public List<Reservation> all() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation get(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
