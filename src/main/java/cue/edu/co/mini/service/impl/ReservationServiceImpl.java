package cue.edu.co.mini.service.impl;

import cue.edu.co.mini.domain.Reservation;
import cue.edu.co.mini.mapping.dtos.ReservationDto;
import cue.edu.co.mini.mapping.mapper.ReservationMapper;
import cue.edu.co.mini.mapping.mapper.UserMapper;
import cue.edu.co.mini.repository.ReservationRepository;
import cue.edu.co.mini.service.ReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
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
     * @return a list of ReservationDto objects.
     */
    @Override
    public List<ReservationDto> getReservations() throws SQLException {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::mapFrom)
                .toList();
    }

    /**
     * Removes a reservation from the reservation repository based on the provided reservation ID.
     *
     * @param id the ID of the reservation to be removed.
     */
    @Override
    public void removeReservation(Long id) throws SQLException {
        reservationRepository.delete(ReservationMapper.mapFrom(getReservationById(id)));
    }

    /**
     * Adds a new reservation to the reservation repository.
     *
     * @param reservation the ReservationDto object to be added.
     */
    @Override
    public void addReservation(ReservationDto reservation) throws SQLException {
        reservationRepository.save(ReservationMapper.mapFrom(reservation));
    }

    /**
     * Retrieves a reservation from the reservation repository based on the provided reservation ID.
     *
     * @param id the ID of the reservation to be retrieved.
     * @return an Optional containing the ReservationDto object if found, or an empty Optional if not found.
     */
    @Override
    public ReservationDto getReservationById(Long id) throws SQLException {
        return reservationRepository.findById(id)
                .map(ReservationMapper::mapFrom)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    /**
     * Retrieves a list of reservations associated with a specific user.
     *
     * @param user the username or identifier of the user.
     * @return a list of ReservationDto objects associated with the user.
     */
    @Override
    public List<Reservation> getReservationsByUser(String user) throws SQLException  {
        return reservationRepository.findAll().stream()
                .filter(reservation -> reservation.equals(user))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of reservations that start at a specific date and time.
     *
     * @param date the date and time at which the reservations start.
     * @return a list of ReservationDto objects that start at the specified date and time.
     */
    /**@Override
    public List<ReservationDto> getReservationsByDateInit(LocalDateTime date) throws SQLException  {
        return reservationRepository.getReservationsByDateInit().stream()
                .filter(reservation -> reservation.reservationInit().equals(reservation))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a list of reservations that end at a specific date and time.
     *
     * @param date the date and time at which the reservations end.
     * @return a list of ReservationDto objects that end at the specified date and time.
     */
    /**@Override
    public List<ReservationDto> getReservationsByDateFinal(LocalDateTime date)  throws SQLException {
        return reservationRepository.getReservationsByDateFinal().stream()
                .filter(reservation -> reservation.reservationFinal().equals(reservation))
                .collect(Collectors.toList());
    }

    /**@Override
    public boolean listVehicleByAvailable(ReservationDto reservation) throws SQLException {
        List<ReservationDto> reservationA = reservationRepository.findDateProblem(
                reservation.vehicle(),
                reservation.reservationInit(),
                reservation.reservationFinal()
        );

        return reservationA.isEmpty();
    }**/
}

