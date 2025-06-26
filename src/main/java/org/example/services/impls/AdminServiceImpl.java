package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.dto.InternshipPostDTO;
import org.example.dto.UserDTO;
import org.example.entity.InternshipPost;
import org.example.entity.User;
import org.example.repository.InternshipPostRepository;
import org.example.repository.UserRepository;
import org.example.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor


public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    private final InternshipPostRepository internshipPostRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<UserDTO> getAllUsers() {
       List<UserDTO>userDTOS=new ArrayList<>();
       List<User> users=userRepository.findAll();
       users.forEach(user -> {
           userDTOS.add(modelMapper.map(user, UserDTO.class));
       });
       return userDTOS;

    }

    @Override
    public List<InternshipPostDTO> getAllPosts() {
     List<InternshipPostDTO> internshipPostDTOS=new ArrayList<>();
     List<InternshipPost>internshipPosts=internshipPostRepository.findAll();
     internshipPosts.forEach(internshipPost -> {
         internshipPostDTOS.add(modelMapper.map(internshipPost, InternshipPostDTO.class));
     });
     return internshipPostDTOS;
    }

    @Override
    public void deleteUser(Long userId) {
       userRepository.deleteById(userId);

    }

    @Override
    public void deletePost(Long postId) {
        internshipPostRepository.deleteById(postId);

    }
}
