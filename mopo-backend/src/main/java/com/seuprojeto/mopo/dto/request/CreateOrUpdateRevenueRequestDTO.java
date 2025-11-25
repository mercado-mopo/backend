package com.seuprojeto.mopo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateOrUpdateRevenueRequestDTO(
  @NotNull @NotBlank String title,
  String description,
  @NotNull @NotBlank String image,
  @NotNull @NotEmpty List<String> ingredients,
  @NotNull @NotEmpty List<String> instructions,
  @NotNull int preparationTimeInMinutes,
  int efficiency,
  int difficulty
) {
}
