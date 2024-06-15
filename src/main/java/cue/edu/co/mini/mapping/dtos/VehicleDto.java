package cue.edu.co.mini.mapping.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;

@Builder
public record VehicleDto(Long idVehicle,
                         @NotNull(message = "no puede ser null")
                         @NotBlank
                         @NotEmpty
                         String name,
                         @NotNull
                         String available,
                         @PositiveOrZero
                         Double price,
                         @NotBlank
                         String type) {
}
