package org.spring.app.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgePackageSetDto {
    private Long id;
    @Size(min = 3, max = 250, message = "Title must be between 3 and 250 characters")
    private String title;
}
