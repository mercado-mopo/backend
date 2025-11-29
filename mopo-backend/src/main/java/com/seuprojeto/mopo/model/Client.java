package com.seuprojeto.mopo.model;

import com.seuprojeto.mopo.model.shared.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "clients")
public class Client extends User {
  @Column(unique = true, length = 11)
  private String cpf = "";

  @Column
  @NotNull(message = "Variable cannot be null")
  private LocalDate birthday;

  public Client() {
  }

  public Client(String username, String email, String password, LocalDate birthday) {
    super(username, email, password);
    this.birthday = birthday;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
}
