package com.seuprojeto.mopo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "revenue")
public class Revenue {
    public Revenue() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String describe;

    @NotBlank
    private String preparationTime;

    @NotBlank
    private String efficiency;

    @NotBlank
    private String createdAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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

    public Revenue(@NotBlank String nome, @NotBlank String describe, @NotBlank String preparationTime,
                   @NotBlank String efficiency, @NotBlank String createdAt) {
        this.name = nome;
        this.describe = describe;
        this.preparationTime = preparationTime;
        this.efficiency = efficiency;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

}
