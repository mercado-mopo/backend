package com.seuprojeto.mopo.dto;

import jakarta.validation.constraints.NotBlank;

public record RevenueRequestDTO(
    @NotBlank String name,
    @NotBlank String describe,
    @NotBlank String preparationTime,
    @NotBlank String efficiency,
    @NotBlank String createdAt
){}
