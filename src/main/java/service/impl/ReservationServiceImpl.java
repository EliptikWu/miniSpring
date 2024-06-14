package service.impl;

import domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;
import service.ReservationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author <a href="https://github.com/EliptikWu"
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Retrieves a list of reservations from the reservation repository.
     *
     * @return a list of Reservation objects.
     */
    @Override
    public List<Reservation> getReservations(){
        return reservationRepository.listReservation();
    }

    /**
     * Removes a reservation from the reservation repository based on the provided reservation ID.
     *
     * @param id the ID of the reservation to be removed.
     */
    @Override
    public void removeReservation(Long id){
        reservationRepository.removeReservation(id);
    }

    /**
     * Adds a new reservation to the reservation repository.
     *
     * @param reservation the Reservation object to be added.
     */
    @Override
    public void addReservation(Reservation reservation){
        reservationRepository.addReservation(reservation);
    }

    /**
     * Saves the provided reservation to the reservation repository.
     * If the reservation already exists, it will be updated; otherwise, a new reservation will be added.
     *
     * @param reservation the Reservation object to be saved.
     */
    @Override
    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    /**
     * Retrieves a reservation from the reservation repository based on the provided reservation ID.
     * @param id the ID of the reservation to be retrieved.
     * @return an Optional containing the Reservation object if found, or an empty Optional if not found.
     */
    @Override
    public Optional<Reservation> getReservationById(Long id){
        return reservationRepository.findById(id);
    }

    /**
     * Retrieves a list of reservations associated with a specific user.
     * @param user the username or identifier of the user.
     * @return a list of Reservation objects associated with the user.
     */
    @Override
    public List<Reservation> getReservationsByUser(String user) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getUser().equals(user))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of reservations that start at a specific date and time.
     * @param date the date and time at which the reservations start.
     * @return a list of Reservation objects that start at the specified date and time.
     */
    @Override
    public List<Reservation> getReservationsByDateInit(LocalDateTime date) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getReservationInit().equals(reservation))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of reservations that end at a specific date and time.
     * @param date the date and time at which the reservations end.
     * @return a list of Reservation objects that end at the specified date and time.
     */
    @Override
    public List<Reservation> getReservationsByDateFinal(LocalDateTime date) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getReservationFinal().equals(reservation))
                .collect(Collectors.toList());
    }
}

