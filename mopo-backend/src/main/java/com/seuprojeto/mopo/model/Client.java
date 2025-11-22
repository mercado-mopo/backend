package com.seuprojeto.mopo.model;

import com.seuprojeto.mopo.model.shared.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Client extends User {
    @Column(nullable = false, unique = true, length = 120)
    private String cpf;

    @Column(nullable = false, length = 120)
    private Date dateOfBirth;
}