package mapping.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDto(Long idUser,
                        @NotNull(message = "no puede ser null")
                        @NotBlank
                        @NotEmpty
                        String name,
                        @Email(message = "Email no valido")
                        String email,
                        @NotNull
                        String telephone,
                        @NotBlank
                        @NotNull
                        String username,
                        @NotBlank
                        @NotNull
                        String password) {
}
