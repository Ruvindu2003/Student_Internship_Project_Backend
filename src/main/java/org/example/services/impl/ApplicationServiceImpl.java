package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Application;
import org.example.dto.InternshipApply;
import org.example.dto.InternshipPost;
import org.example.entity.ApplicationEntity;
import org.example.entity.UserEntity;
import org.example.repository.ApplicationRepository;
import org.example.repository.InternshipPostRepository;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final InternshipPostRepository postRepository;
    private final ModelMapper modelMapper;


}
