package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.dto.ApplicationDTO;
import org.example.entity.Application;
import org.example.entity.InternshipPost;
import org.example.entity.User;
import org.example.repository.ApplicationRepository;
import org.example.repository.InternshipPostRepository;
import org.example.repository.UserRepository;
import org.example.services.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    private final InternshipPostRepository internshipPostRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;



    @Override
    public ApplicationDTO apply(Long studentId, Long postId, String resumeLink) {
        User student = userRepository.findById(studentId).orElseThrow();
        InternshipPost post = internshipPostRepository.findById(postId).orElseThrow();
        Application application = Application.builder()
                .student(student)
                .post(post)
                .status("APPLIED")
                .resumeLink(resumeLink)
                .build();
        application = applicationRepository.save(application);
        return modelMapper.map(application, ApplicationDTO.class);
    }

    @Override
    public List<ApplicationDTO> getApplicationsByStudent(Long studentId) {
        return applicationRepository.findAll().stream()
                .filter(app -> app.getStudent().getId().equals(studentId))
                .map(app -> modelMapper.map(app, ApplicationDTO.class))
                .collect(Collectors.toList());
    }

    }

