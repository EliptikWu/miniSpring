package cue.edu.co.mini.mapping.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDto(
        @NotBlank
        @NotNull
        String username,
        @NotBlank
        @NotNull
        String password
) {
}
