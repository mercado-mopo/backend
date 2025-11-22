package com.seuprojeto.mopo.dto.response;

import com.seuprojeto.mopo.model.Revenue;

import java.util.List;
import java.util.UUID;

public record RevenueResponseDTO(
        UUID id,
        String title,
        String describe,
        String image,
        List<String> ingredients,
        List<String> instructions,
        int preparationTime,
        int efficiency,
        int rating,
        int difficulty
) {
    public RevenueResponseDTO(Revenue entity) {
        this(entity.getId(),
                entity.getTitle(),
                entity.getDescribe(),
                entity.getImage(),
                entity.getIngredients(),
                entity.getInstructions(),
                entity.getPreparationTime(),
                entity.getEfficiency(),
                entity.getRating(),
                entity.getDifficulty());
    }
}
