package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Application;
import org.example.entity.ApplicationEntity;
import org.example.repository.ApplicationRepository;
import org.example.services.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<Application> getAll() {
        List<Application>applications=new ArrayList<>();
        List<ApplicationEntity> applicationEntities=applicationRepository.findAll();
        applicationEntities.forEach(applicationEntity -> {
            applications.add(modelMapper.map(applicationEntity, Application.class));
        });

        return List.of();
    }

    @Override
    public Application SearchById(Long id) {

        Optional<ApplicationEntity>applicationEntity=applicationRepository.findById(id);
      return   applicationEntity.map(applicationEntity1 -> modelMapper.map(applicationEntity1,Application.class)).orElse(null);

    }

    @Override
    public boolean deleteApplication(Long id) {
        if (id==null){
            return  false;

        }
        applicationRepository.deleteById(id);

        return  true;

    }

    @Override
    public boolean updateApplication(Application application) {

        applicationRepository.save(modelMapper.map(application,ApplicationEntity.class));

        return false;
    }

    @Override
    public boolean addApplication(Application application) {
        applicationRepository.save(modelMapper.map(application,ApplicationEntity.class));

        return false;
    }
}
