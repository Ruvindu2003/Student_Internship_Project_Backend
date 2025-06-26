package org.example.services;

import org.example.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
    public ApplicationDTO apply(Long studentId, Long postId, String resumeLink);
    public List<ApplicationDTO> getApplicationsByStudent(Long studentId);


}
