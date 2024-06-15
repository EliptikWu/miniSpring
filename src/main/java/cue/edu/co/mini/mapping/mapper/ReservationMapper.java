package cue.edu.co.mini.mapping.mapper;

import cue.edu.co.mini.domain.Reservation;
import cue.edu.co.mini.mapping.dtos.ReservationDto;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationMapper {
    public static ReservationDto mapFrom(Reservation reservationMapper){
        return new ReservationDto(reservationMapper.getIdReservation(),
                reservationMapper.getName(),
                reservationMapper.getPrice(),
                reservationMapper.getDescription(),
                reservationMapper.getUser(),
                reservationMapper.getVehicle(),
                reservationMapper.getReservationInit(),
                reservationMapper.getReservationFinal());
    }

    public static Reservation mapFrom(ReservationDto reservationMapper){
        return new Reservation(reservationMapper.idReservation(),
                reservationMapper.name(),
                reservationMapper.price(),
                reservationMapper.description(),
                reservationMapper.user(),
                reservationMapper.vehicle(),
                reservationMapper.reservationInit(),
                reservationMapper.reservationFinal());
    }

    public static List<ReservationDto> mapFrom(List<Reservation> reservationMapper){
        return reservationMapper.stream().map(ReservationMapper::mapFrom).collect(Collectors.toList());
    }

    public static List<Reservation> mapFromDto(List<ReservationDto> reservationMapper){
        return reservationMapper.stream().map(ReservationMapper::mapFrom).collect(Collectors.toList());
    }
}
