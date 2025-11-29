package com.seuprojeto.mopo.model.shared;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class User {
  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "Username cannot be blank")
  @NotNull(message = "Variable cannot be null")
  @Column(unique = true, length = 100)
  private String username = "";

  @Email(message = "Invalid email")
  @NotBlank(message = "Email cannot be blank")
  @NotNull(message = "Variable cannot be null")
  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @NotBlank(message = "Password cannot be blank")
  @NotNull(message = "Variable cannot be null")
  @Column(nullable = false)
  private String password;

  @NotNull(message = "Variable cannot be null")
  @Column(length = 15)
  private String telephone = "";

  @Column(nullable = false)
  private boolean isActive = true;

  @Column
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public UUID getId() {
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public boolean isActive() {
    return isActive;
  }

  public void toggleActive() {
    this.isActive = !this.isActive;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
