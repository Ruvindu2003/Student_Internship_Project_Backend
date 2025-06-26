package org.example.services;

import org.example.dto.UserDTO;

public interface AuthService {
    public UserDTO register(UserDTO userDTO, String password);

    public String authenticate(String username, String password);


}
