package org.example.repository;

import org.example.dto.InternshipPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipPostRepository extends JpaRepository<InternshipPost, Long> {
    List<InternshipPost> findByCreatedBy_Id(Long companyId);
}
