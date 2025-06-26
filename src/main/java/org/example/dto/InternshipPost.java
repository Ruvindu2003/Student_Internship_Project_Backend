package org.example.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternshipPost {

    private Long id;

    private String title;

    private String description;

    private String location;

    private String duration;

    private Long companyId;

    private String companyName;

}
