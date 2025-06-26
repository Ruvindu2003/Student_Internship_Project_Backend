package org.example.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Application {

    private Long id;

    private String status;

    private String resumeLink;

    private Long studentId;

    private String studentName;

    private Long postId;

    private String postTitle;

}
