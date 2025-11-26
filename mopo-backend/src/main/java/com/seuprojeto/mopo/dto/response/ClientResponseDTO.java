package com.seuprojeto.mopo.dto.response;

import java.util.UUID;

public record ClientResponseDTO(UUID id, String username, String email, String telephone) {
}
