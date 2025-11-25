package com.seuprojeto.mopo.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateOrUpdateRevenueRequestDTO(
  @NotBlank String title,
  @NotBlank String description,
  @NotBlank String preparationTime,
  @NotBlank String efficiency,
  @NotBlank String createAt
) {
}
