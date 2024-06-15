package cue.edu.co.mini.controllers;

import cue.edu.co.mini.mapping.dtos.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cue.edu.co.mini.service.ReservationService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/get-reservations")
    public List<ReservationDto> getAllReservation()throws SQLException {
        return reservationService.getReservations();
    }

    @DeleteMapping(value = "/delete-reservations/{id}")
    public void removeReservation(@PathVariable Long id) throws SQLException{
        reservationService.removeReservation(id);
    }

    @PostMapping(value = "/add-reservation")
    public void addReservation(@RequestBody ReservationDto reservation)throws SQLException {
        reservationService.addReservation(reservation);
    }
}
