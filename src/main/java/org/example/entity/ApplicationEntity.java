package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.Application;
import org.example.dto.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "application")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String location;

    private String duration;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private User createdBy;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications = new ArrayList<>();

}
