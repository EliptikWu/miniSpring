package cue.edu.co.mini.repository;

import cue.edu.co.mini.domain.Reservation;
import cue.edu.co.mini.domain.Vehicle;
import cue.edu.co.mini.mapping.dtos.ReservationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**List<ReservationDto> listReservation();
    void removeReservation(Long id);
    void addReservation(ReservationDto reservation);
    Optional<ReservationDto> getReservationById(Long id);
    void saveReservation(ReservationDto reservation);
    List<ReservationDto> getReservationsByUser();
    List<ReservationDto> getReservationsByDateInit();
    List<ReservationDto> getReservationsByDateFinal();
    List<ReservationDto> findDateProblem(Vehicle vehicle, LocalDateTime dateInit, LocalDateTime dateFinal);
    ;**/

    
}
