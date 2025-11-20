package com.seuprojeto.mopo.dto;

import java.util.UUID;

public record UserResponseDTO(UUID id, String nome, String email, String telephone) {
}
