package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.Client;

import java.util.UUID;

public record ClientResponseDTO(UUID id, String name, String email, String telephone) {
    public ClientResponseDTO(Client entity) {
        this(entity.getId(), entity.getUsername(), entity.getEmail(), null);
    }
}
