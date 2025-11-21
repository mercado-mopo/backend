package com.seuprojeto.mopo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "revenue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 120)
    @NotNull
    @NotBlank
    private String title;

    @Column(length = 300)
    private String describe;

    @Column
    @Lob
    private String image;

    @Column(nullable = false)
    @NotEmpty
    private List<@NotBlank String> ingredients;

    @Column(nullable = false)
    @NotEmpty
    private List<@NotBlank String> instructions;

    @Column(nullable = false, length = 5760)
    @NotNull
    private int preparationTime;

    @Column(length = 100)
    private int efficiency;

    @Column(length = 5)
    private int rating;

    @Column(length = 5)
    private int difficulty;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String updatedAt;
}
