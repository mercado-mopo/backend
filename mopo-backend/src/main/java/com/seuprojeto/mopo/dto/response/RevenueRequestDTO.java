package com.seuprojeto.mopo.dto.response;

import jakarta.validation.constraints.NotBlank;

public record RevenueRequestDTO(
        String name,
        String describe,
        int preparationTime,
        int efficiency
        ) {
}
