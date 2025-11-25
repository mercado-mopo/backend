package com.seuprojeto.mopo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "revenues")
public class Revenue {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String title;

  @NotBlank
  private String description;

  @NotBlank
  private String preparationTime;

  @NotBlank
  private String efficiency;

  @NotBlank
  private String createdAt;

  public Revenue() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPreparationTime() {
    return preparationTime;
  }

  public void setPreparationTime(String preparationTime) {
    this.preparationTime = preparationTime;
  }

  public String getEfficiency() {
    return efficiency;
  }

  public void setEfficiency(String efficiency) {
    this.efficiency = efficiency;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Revenue(@NotBlank String nome, @NotBlank String description, @NotBlank String preparationTime,
                 @NotBlank String efficiency, @NotBlank String createdAt) {
    this.title = nome;
    this.description = description;
    this.preparationTime = preparationTime;
    this.efficiency = efficiency;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

}
