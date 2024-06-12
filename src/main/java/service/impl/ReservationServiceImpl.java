package service.impl;

import domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;
import service.ReservationService;

import java.util.List;
import java.util.Optional;

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
}

