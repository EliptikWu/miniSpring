package mapping.dtos;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record PaymentDto( Long idPayment,
                          @NotNull
                          @Positive
                          Long idVehicle,
                          @NotNull
                          @Positive
                          Long idReservation,
                          @NotNull
                          @Positive
                          Long idUser) {
}
