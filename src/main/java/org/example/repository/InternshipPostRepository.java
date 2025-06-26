package org.example.repository;

import org.example.entity.InternshipPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipPostRepository extends JpaRepository<InternshipPost, Long> {
} 