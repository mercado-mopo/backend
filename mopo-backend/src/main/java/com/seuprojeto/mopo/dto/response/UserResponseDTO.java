package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.Client;

public record UserResponseDTO(String username, String email) {
    public UserResponseDTO(Client entity) {
        this(entity.getUsername(), entity.getEmail());
    }
}
