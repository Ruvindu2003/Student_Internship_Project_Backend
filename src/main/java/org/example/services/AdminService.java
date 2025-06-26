package org.example.services;

import org.example.dto.InternshipPostDTO;
import org.example.dto.UserDTO;

import java.util.List;

public interface AdminService {
    public List<UserDTO> getAllUsers();
    public List<InternshipPostDTO> getAllPosts();
    public void deleteUser(Long userId);
    public void deletePost(Long postId);




}
