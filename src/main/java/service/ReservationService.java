package service;

import domain.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

        List<Reservation> getReservations();
        void removeReservation(Long id);
        void addReservation(Reservation reservation);
        Optional<Reservation> getReservationById(Long id);
        void saveReservation(Reservation reservation);
        List<Reservation> getReservationsByUser(String user);
        List<Reservation> getReservationsByDateInit(LocalDateTime date);
        List<Reservation> getReservationsByDateFinal(LocalDateTime date);
}
