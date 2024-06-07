package mapping.dtos;

import lombok.Builder;

@Builder
public record VehicleDto(Long idVehicle,
                         String name,
                         String available,
                         Double price,
                         String type) {
}
