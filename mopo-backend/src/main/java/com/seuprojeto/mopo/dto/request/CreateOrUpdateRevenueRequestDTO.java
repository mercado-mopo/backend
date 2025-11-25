package com.seuprojeto.mopo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrUpdateRevenueRequestDTO(
  @NotNull(message = "Variable cannot be null") @NotBlank String title,
  String description,
  @NotNull(message = "Variable cannot be null") @NotBlank String image,
  @NotNull(message = "Variable cannot be null") @NotEmpty(message = "List cannot be empty") List<String> ingredients,
  @NotNull(message = "Variable cannot be null") @NotEmpty(message = "List cannot be empty") List<String> instructions,
  @NotNull(message = "Variable cannot be null") int preparationTimeInMinutes,
  int efficiency,
  int rating,
  int difficulty
) {
}
