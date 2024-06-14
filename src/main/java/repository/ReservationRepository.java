package repository;

import domain.Reservation;
import mapping.dtos.ReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<ReservationDto> listReservation();
    void removeReservation(Long id);
    void addReservation(ReservationDto reservation);
    Optional<ReservationDto> getReservationById(Long id);
    void saveReservation(ReservationDto reservation);
    List<ReservationDto> getReservationsByUser();
    List<ReservationDto> getReservationsByDateInit();
    List<ReservationDto> getReservationsByDateFinal();
}
