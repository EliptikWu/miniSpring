package mapping.dtos;

import domain.User;
import domain.Vehicle;
import jakarta.validation.constraints.*;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ReservationDto( Long idReservation,
                              @NotNull(message = "no puede ser null")
                              @NotBlank
                              @NotEmpty
                              String name,
                              @PositiveOrZero
                              Double price,
                              @NotEmpty
                              String description,
                              @NotNull
                              @Positive
                              User user,
                              @NotNull
                              @Positive
                              Vehicle vehicle,
                              @NotNull
                              @NotBlank
                              LocalDateTime reservationInit,
                              @NotNull
                              @NotBlank
                              LocalDateTime reservationFinal) {

}

