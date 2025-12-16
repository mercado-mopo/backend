package com.seuprojeto.mopo.dto.request;

import java.util.List;

public record RevenueRequestDTO(
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
}
