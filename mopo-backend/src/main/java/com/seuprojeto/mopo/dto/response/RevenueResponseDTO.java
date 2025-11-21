package com.seuprojeto.mopo.dto.response;

import java.util.List;
import java.util.UUID;

public record RevenueResponseDTO(UUID id,
                                 String title,
                                 String describe,
                                 String image,
                                 List<String> ingredients,
                                 List<String> instructions,
                                 int preparationTime,
                                 int efficiency,
                                 int rating,
                                 int difficulty) {
}
