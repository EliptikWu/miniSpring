package mapping.dtos;
import lombok.Builder;

@Builder
public record PaymentDto( Long idPayment,
                          Long idVehicle,
                          Long idReservation,
                          Long idUser) {
}
