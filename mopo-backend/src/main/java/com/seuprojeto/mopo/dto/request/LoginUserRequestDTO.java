package com.seuprojeto.mopo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record LoginUserRequestDTO(
        String username,
        String email,
        String password
) {
}
