package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.dto.InternshipPostDTO;
import org.example.entity.InternshipPost;
import org.example.entity.User;
import org.example.repository.InternshipPostRepository;
import org.example.repository.UserRepository;
import org.example.services.InternshipPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InternShipServiceImpl implements InternshipPostService {

    private final InternshipPostRepository internshipPostRepository;

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;


    @Override
    public InternshipPostDTO createPost(InternshipPostDTO dto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        InternshipPost post = modelMapper.map(dto, InternshipPost.class);
        post.setCreatedBy(user);
        post = internshipPostRepository.save(post);
        return modelMapper.map(post, InternshipPostDTO.class);
    }

    @Override
    public List<InternshipPostDTO> getAllPosts() {
       List<InternshipPostDTO>internshipPostDTOS=new ArrayList<>();
       List<InternshipPost> internshipPosts=internshipPostRepository.findAll();
       internshipPosts.forEach(internshipPost -> {
           internshipPostDTOS.add(modelMapper.map(internshipPost, InternshipPostDTO.class));
       });
       return internshipPostDTOS;
    }

    @Override
    public List<InternshipPostDTO> searchPosts(String keyword) {
        return internshipPostRepository.findAll().stream()
                .filter(post -> post.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        post.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                        post.getLocation().toLowerCase().contains(keyword.toLowerCase()))
                .map(post -> modelMapper.map(post, InternshipPostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InternshipPostDTO> filterPosts(String location, String duration) {
        return internshipPostRepository.findAll().stream()
                .filter(post -> (location == null || post.getLocation().equalsIgnoreCase(location)) &&
                        (duration == null || post.getDuration().equalsIgnoreCase(duration)))
                .map(post -> modelMapper.map(post, InternshipPostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public InternshipPostDTO searchByIdPsosts(Long id) {
        Optional<InternshipPost>internshipPost=internshipPostRepository.findById(id);
      return   internshipPost.map(internshipPost1 -> modelMapper.map(internshipPost1, InternshipPostDTO.class)).orElse(null);


    }
}

