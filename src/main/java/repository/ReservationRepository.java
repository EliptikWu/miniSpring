package repository;

import domain.Reservation;
import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> listReservation();
    void removeReservation(Long id);
    void addReservation(Reservation reservation);
    Optional<Reservation> getReservationById(Long id);
    void saveReservation(Reservation reservation);
    List<Reservation> getReservationsByUser(String user);
    List<Reservation> getReservationsByDateInit(LocalDateTime date);
    List<Reservation> getReservationsByDateFinal(LocalDateTime date);
}
