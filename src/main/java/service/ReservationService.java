package service;

import domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

        List<Reservation> getReservations();
        void removeReservation(Long id);
        void addReservation(Reservation reservation);
        Optional<Reservation> getReservationById(Long id);
        void saveReservation(Reservation reservation);
}
