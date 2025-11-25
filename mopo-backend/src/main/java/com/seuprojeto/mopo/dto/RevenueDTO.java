package com.seuprojeto.mopo.dto;

import jakarta.validation.constraints.NotBlank;

public record RevenueDTO(
  @NotBlank String title,
  @NotBlank String description,
  @NotBlank String preparationTime,
  @NotBlank String efficiency,
  @NotBlank String createAt
) {
}
