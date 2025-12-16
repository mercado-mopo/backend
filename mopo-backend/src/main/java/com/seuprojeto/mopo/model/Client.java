package com.seuprojeto.mopo.model;

import com.seuprojeto.mopo.model.shared.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Client extends User {
    @Column(unique = true, length = 120)
    private String cpf;

    @Column
    private Date dateOfBirth;
}
