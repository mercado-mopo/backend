package com.seuprojeto.mopo.dto;

import jakarta.validation.constraints.NotBlank;

public record ReceitaDTO(
  @NotBlank String nome,
  @NotBlank String descricao,
  @NotBlank String tempoPreparo,
  @NotBlank String rendimento,
  @NotBlank String dataInsercao
) {
}
