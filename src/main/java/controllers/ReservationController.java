package controllers;

import domain.Reservation;
import domain.Vehicle;
import mapping.dtos.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ReservationService;
import service.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/get-reservations")
    public List<ReservationDto> getAllReservation() {
        return reservationService.getReservations();
    }

    @DeleteMapping(value = "/delete-reservations/{id}")
    public void removeReservation(@PathVariable Long id) {
        reservationService.removeReservation(id);
    }

    @PostMapping(value = "/add-reservation")
    public void addReservation(@RequestBody ReservationDto reservation) {
        reservationService.addReservation(reservation);
    }
}
