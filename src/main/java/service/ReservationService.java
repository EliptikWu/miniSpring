package service;

import mapping.dtos.ReservationDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

        List<ReservationDto> getReservations();
        void removeReservation(Long id);
        void addReservation(ReservationDto reservation);
        Optional<ReservationDto> getReservationById(Long id);
        void saveReservation(ReservationDto reservation);
        List<ReservationDto> getReservationsByUser(String user);
        List<ReservationDto> getReservationsByDateInit(LocalDateTime date);
        List<ReservationDto> getReservationsByDateFinal(LocalDateTime date);
        boolean listVehicleByAvailable(ReservationDto reservation);
}
