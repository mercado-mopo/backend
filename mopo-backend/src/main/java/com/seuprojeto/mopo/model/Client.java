package com.seuprojeto.mopo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome não pode ser vazio")
  private String username;

  @Email(message = "E-mail inválido")
  @NotBlank(message = "O e-mail é obrigatório")
  private String email;

  @NotBlank(message = "O telefone é obrigatório")
  private String telephone;

  public Client() {
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
}
