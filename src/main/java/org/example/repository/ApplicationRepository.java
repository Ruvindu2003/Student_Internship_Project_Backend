package org.example.repository;

import org.example.dto.Application;
import org.example.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Long> {

    List<Application> findByStudent_Id(Long studentId);

    List<Application> findByPost_Id(Long postId);

}
