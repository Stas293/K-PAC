package org.spring.app.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewKnowledgePackageSetDto {
    private Long id;
    @Size(min = 3, max = 250, message = "Title must be between 3 and 250 characters")
    private String title;
    private List<Long> knowledgePackages;
}
