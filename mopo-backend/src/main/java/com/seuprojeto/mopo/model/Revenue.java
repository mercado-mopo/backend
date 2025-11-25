package com.seuprojeto.mopo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "revenues")
public class Revenue {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(length = 100, nullable = false)
  private String title;

  @Column(length = 300)
  private String description;

  @Column
  @Lob
  private String image;

  @Column(nullable = false)
  @NotEmpty(message = "List cannot be empty")
  private List<@NotEmpty(message = "Variable cannot be empty") @NotNull(message = "Variable cannot be null") String> ingredients = new ArrayList<>();

  @Column(nullable = false)
  @NotEmpty(message = "List cannot be empty")
  private List<@NotEmpty(message = "Variable cannot be empty") @NotNull(message = "Variable cannot be null") String> instructions = new ArrayList<>();

  private int preparationTime;

  @Column
  private int efficiency;

  @Column
  private int rating;

  @Column
  private int difficulty;

  @CreationTimestamp
  @Column
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column
  private LocalDateTime updatedAt;

  public Revenue() {
  }

  public Revenue(
    String title,
    String image,
    List<String> ingredients,
    List<String> instructions,
    int preparationTime) {
    this.title = title;
    this.image = image;
    this.ingredients = ingredients;
    this.instructions = instructions;
    this.preparationTime = preparationTime;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(int difficulty) {
    this.difficulty = difficulty;
  }

  public int getRating() {
    return rating;
  }

  public int getEfficiency() {
    return efficiency;
  }

  public void setEfficiency(int efficiency) {
    this.efficiency = efficiency;
  }

  public int getPreparationTime() {
    return preparationTime;
  }

  public void setPreparationTime(int preparationTime) {
    this.preparationTime = preparationTime;
  }

  public List<String> getInstructions() {
    return instructions;
  }

  public void updateInstructions(List<String> instructions) {
    BeanUtils.copyProperties(instructions, this.instructions);
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  public void updateIngredients(List<String> ingredients) {
    BeanUtils.copyProperties(ingredients, this.ingredients);
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UUID getId() {
    return id;
  }
}
