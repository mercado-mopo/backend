package com.seuprojeto.mopo.dto.request;

import java.util.Date;

public record CreateClientRequestDTO(
        String username,
        String email,
        String password,
        String confirmPassword,
        String telephone,
        String cpf,
        Date birthday) {
    public CreateClientRequestDTO(
            String name,
            String email,
            String password,
            String confirmPassword) {
        this(name, email, password, confirmPassword, null, null, null);
    }
}
