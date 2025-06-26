package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.InternshipPost;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.repository.InternshipPostRepository;
import org.example.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InternshipPostServiceImpl {
    private final InternshipPostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public InternshipPost createPost(InternshipPost dto, Long companyId) {
        InternshipPost post = modelMapper.map(dto, InternshipPost.class);
        UserEntity company = userRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
        InternshipPost saved = postRepository.save(post);

        InternshipPost result = modelMapper.map(saved, InternshipPost.class);
        result.setCompanyId(company.getId());
        result.setCompanyName(company.getUsername());
        return result;
    }

    public List<InternshipPost> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> {
                    InternshipPost dto = modelMapper.map(post, InternshipPost.class);
                    dto.setCompanyId(post.getId());
                    dto.setCompanyName(post.getCompanyName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public List<InternshipPost> getPostsByCompany(Long companyId) {
        return postRepository.findByCreatedBy_Id(companyId).stream()
                .map(post -> {
                    InternshipPost dto = modelMapper.map(post, InternshipPost.class);
                    dto.setCompanyId(post.getId());
                    dto.setCompanyName(post.getCompanyName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public InternshipPost getById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }
}
