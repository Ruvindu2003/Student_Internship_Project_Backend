package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternshipPostDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String duration;
    private Long createdById;
    private String createdByUsername;
} 