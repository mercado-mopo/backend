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

  private String title;

  private String description;

  private int preparationTime;

  private int efficiency;

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

  public int getPreparationTime() {
    return preparationTime;
  }

  public void setPreparationTime(int preparationTime) {
    this.preparationTime = preparationTime;
  }

  public int getEfficiency() {
    return efficiency;
  }

  public void setEfficiency(int efficiency) {
    this.efficiency = efficiency;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Revenue(String nome, String description, int preparationTime,
                 int efficiency) {
    this.title = nome;
    this.description = description;
    this.preparationTime = preparationTime;
    this.efficiency = efficiency;
  }

  public Long getId() {
    return id;
  }

}
