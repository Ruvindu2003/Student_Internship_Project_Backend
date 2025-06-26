package org.example.services;

import org.example.dto.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getAll();
    Application SearchById(Long id);
    boolean deleteApplication(Long id);
    boolean updateApplication(Application application);
    boolean addApplication(Application application);


}
