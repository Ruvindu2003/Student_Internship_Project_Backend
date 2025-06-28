package org.example.services;

import org.example.dto.ApplicationDTO;
import org.example.dto.InternshipPostDTO;

import java.util.List;

public interface InternshipPostService {
    public InternshipPostDTO createPost(InternshipPostDTO dto, Long userId);
     List<InternshipPostDTO> getAllPosts();
    public List<InternshipPostDTO> searchPosts(String keyword);
    public List<InternshipPostDTO> filterPosts(String location, String duration);
    InternshipPostDTO searchByIdPsosts(Long id);


}
