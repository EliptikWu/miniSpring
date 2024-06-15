package cue.edu.co.mini.service;

import cue.edu.co.mini.domain.Reservation;
import cue.edu.co.mini.mapping.dtos.ReservationDto;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

        List<ReservationDto> getReservations() throws SQLException;
        void removeReservation(Long id) throws SQLException ;
        void addReservation(ReservationDto reservation) throws SQLException ;
        ReservationDto getReservationById(Long id) throws SQLException ;
        List<Reservation> getReservationsByUser(String user) throws SQLException ;
        /**List<ReservationDto> getReservationsByDateInit(LocalDateTime date) throws SQLException ;
        List<ReservationDto> getReservationsByDateFinal(LocalDateTime date) throws SQLException ;
        boolean listVehicleByAvailable(ReservationDto reservation) throws SQLException ;**/
}
