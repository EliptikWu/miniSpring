package mapping.dtos;

import domain.User;
import domain.Vehicle;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ReservationDto( Long idReservation,
                              String name,
                              Double price,
                              String description,
                              User user,
                              Vehicle vehicle,
                              LocalDateTime reservationInit,
                              LocalDateTime reservationFinal) {

}

