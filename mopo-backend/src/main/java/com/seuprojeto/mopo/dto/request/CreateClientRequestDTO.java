package com.seuprojeto.mopo.dto.request;

import java.util.Date;

public record CreateClientRequestDTO(String name,
                                     String email,
                                     String password,
                                     String telephone,
                                     String cpf,
                                     Date birthday) {
}
